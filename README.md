#  kotlin-hints

kotlin-hints is a collection of Kotlin hints/idioms/patterns.

Writing idiomatic Kotlin code can be hard, especially when just learning the language.

More importantly, it's not always clear in which ways can existing Kotlin code be improved to become either shorter, faster, more readable or more maintainable.

There are good tools which help with that, including Intellij IDEA inspections and [detekt](https://github.com/arturbosch/detekt), the static code analysis tool.

This project attempts to go beyond and lists the patterns which are not covered by the above tools.

Some of the patterns are not covered by these tools by design, however the list will also contain the items which are not yet implemented in these tools.

Most of the examples are taken from the [Kotlin Language Reference](https://kotlinlang.org/docs/reference/).

---

**Table of Contents**

* [kotlin-hints](#kotlin-hints)
  * [Extensions](#extensions)
     * [Utility class](#utility-class)
     * [Extension property](#extension-property)
  * [Functions](#functions)
     * [Single expression in a block body](#single-expression-in-a-block-body)
     * [Method overload](#method-overload)
     * [Named arguments](#named-arguments)
     * [Infix function](#infix-function)
  * [Lambdas](#lambdas)
     * [Single parameter](#single-parameter)
  * [Imports](#imports)
     * [Name clash](#name-clash)
  * [Data classes](#data-classes)
     * [Destructure](#destructure)
  * [If expressions](#if-expressions)
     * [If not null](#if-not-null)
  * [When expressions](#when-expressions)
     * [Type check](#type-check)
  * [Maps](#maps)
     * [Traverse keys and values](#traverse-keys-and-values)
  * [Ranges](#ranges)
     * [Exclusive upper limit](#exclusive-upper-limit)
  * [With expressions](#with-expressions)
     * [Multiple method calls on an object](#multiple-method-calls-on-an-object)

## Extensions
### Utility class

Utility class could be replaced with function extensions.

```kotlin
// [Before]
class StringUtils {
    fun swapCase(str: String): String { ... }
}
```

```kotlin
// [After]
fun String.swapCase(): String { ... }

"Hello World".swapCase()
```

### Extension property

Commonly used expressions made on a class property can be added to a class as an extension property instead.

```kotlin
// [Before]
println("Last index: ${list.size - 1}")

// [After]
val <T> List<T>.lastIndex: Int
    get() = size - 1

println("Last index: ${list.lastIndex}")
```

## Functions
### Single expression in a block body

Could be converted to the expression body. Return type could then be inferred.

**NB**: Intellij IDEA has intentions for:
* Converting between a block and expression body.
* Specifying/removing an explicit return type.

```kotlin
// [Before]

fun sum(a: Int, b: Int): Int {
    return a + b
}

// [After]
fun sum(a: Int, b: Int) = a + b
```

Same applies for `if` and `when`, as these are expressions in Kotlin.

```kotlin
// [Before]
fun maxOf(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// [After]
fun maxOf(a: Int, b: Int) = if (a > b) a else b
```

```kotlin
// [Before]
fun countryCode(country: String): String {
    return when(country){
        "China" -> "CHN"
        "Japan" -> "JPN"
        else -> throw UnsupportedOperationException("Unknown country: $country")
    }
}

// [After]
fun countryCode(country: String) = when(country){
    "China" -> "CHN"
    "Japan" -> "JPN"
    else -> throw UnsupportedOperationException("Unknown country: $country")
}
```

### Method overload

Overloading methods with the reduced number of arguments can be avoided by providing *default values* for parameters.

```kotlin
// [Before]
fun printNumber() = printNumber(0)
fun printNumber(a: Int) = println("Number: $a")

// [After]
fun printNumber(a: Int = 0) = println("Number: $a")
```

### Named arguments

Function parameters can be named when calling a function.

```kotlin
fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ') {
    ...
}

// [Before]

reformat("hello,world", false, false, true, ',')

// [After]
reformat("hello,world", normalizeCase = false, upperCaseFirstLetter = false, divideByCamelHumps = true, wordSeparator = ',')
```

### Infix function

Allows using functions in the form of `a rem b` instead of `a.rem(b)`.

```kotlin
// [Before]
1.rem(2)

// [After]
infix fun Int.rem(num: Int) = this.rem(num)
1 rem 2
```

## Lambdas
### Single parameter

Could use an implicit name `it` to simplify an expression.

**NB**: Intellij IDEA has an intention that performs the following transformation.

```kotlin
// [Before]
numbers.filter { n -> n > 0 }

// [After]
numbers.filter { it > 0 }
```

## Imports
### Name clash

Avoid writing a fully qualified name for the class in the scenario of an import name clash by disambiguating a class with a keyword `as`.

```kotlin
val utilDate: Date
val sqlDate: java.sql.Date

// [After]
import java.sql.Date as SqlDate
...
val utilDate: Date
val sqlDate: SqlDate
```

## Data classes
### Destructure

Could destructure a data class when only it's internals are used within a scope.

```kotlin
data class User(val name: String = "", val age: Int = 0)

val alice = User("Alice", 22)
val ageLimit = 18

// [Before]
println("Name: $alice.name, Age: $alice.age")
if (alice.age >= ageLimit) println("$alice.name is over $ageLimit")

// [After]
val (name, age) = alice
println("Name: $name, Age: $age")
if (age >= ageLimit) println("$name is over $ageLimit")
```

## If expressions
### If not null

Could be replaced with a safe access expression.

**NB**: Intellij IDEA has intentions for converting between these two idioms.

```kotlin
// [Before]
fun middleNameLength(middleName: String?) = if (middleName != null) middleName.length else null

// [After]
fun middleNameLength(middleName: String?) = middleName?.length
```

## When expressions
### Type check

Type checks can be used in `when` expressions.

```kotlin
// [Before]
if (obj is String) {
    println("Text: $obj")
} else if (obj is Number) {
    println("Number: $obj")
} else {
    println("Unknown: $obj")
}

// [After]
when (obj) {
    is String -> println("Text: $obj")
    is Number -> println("Number: $obj")
    else -> println("Unknown: $obj")
}
```

## Maps
### Traverse keys and values

Destructure a map to use key and value directly.

```kotlin
// [Before]
map.forEach { entry -> println("${entry.key} -> ${entry.value}") }

// [After]
map.forEach { (k, v) -> println("$k -> $v") }
```

## Ranges
### Exclusive upper limit

Use `until` operator to exclude the upper limit.

```kotlin
// Printing out numbers from 1 up to but excluding 10 (half-open range)

const val LIMIT = 10

// [Before]
for (i in 1..(LIMIT - 1)) println(i)

// [After]
for (i in 1 until LIMIT) println(i)
```

## With expressions
### Multiple method calls on an object

`with` expression could be used.

```kotlin
// [Before]
fun printMenu(pizzas: List<String>) {
    pizzas.forEach { println("Large $it") }
    pizzas.forEach { println("Medium $it") }
    pizzas.forEach { println("Small $it") }
}

// [After]
fun printMenu(pizzas: List<String>) = with(pizzas) {
    forEach { println("Large $it") }
    forEach { println("Medium $it") }
    forEach { println("Small $it") }
}
```