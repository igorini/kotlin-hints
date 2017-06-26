#  kotlin-hints

kotlin-hints is a collection of Kotlin hints/idioms/patterns.

Writing idiomatic Kotlin code can be hard, especially when just learning the language.

More importantly, it's not always clear in which ways can existing Kotlin code be improved to become either shorter, faster, more readable or more maintainable.

There are good tools which help with that, including Intellij IDEA inspections and [detekt](https://github.com/arturbosch/detekt), the static code analysis tool.

This project attempts to go beyond and lists the patterns which are not covered by the above tools.

Some of the patterns are not covered by these tools by design, however the list will also contain the items which are not yet implemented in these tools.

Most of the examples are taken from the [Kotlin Language Reference](https://kotlinlang.org/docs/reference/)

---

**Table of Contents**

* [kotlin-hints](#kotlin-hints)
  * [Extensions](#extensions)
     * [Utility class](#utility-class)
  * [Functions](#functions)
     * [Single expression in a block body](#single-expression-in-a-block-body)
     * [Method overload](#method-overload)
  * [Lambdas](#lambdas)
     * [Single parameter](#single-parameter)
  * [When expressions](#when-expressions)
     * [Type check](#type-check)
  * [Maps](#maps)
     * [Traverse keys and values](#traverse-keys-and-values)
  * [Ranges](#ranges)
     * [Exclusive upper limit](#exclusive-upper-limit)

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

## Functions
### Single expression in a block body

Could be converted to the expression body. Return type could then be inferred.

**NB**: Intellij IDEA has intentions for:
* Converting between a block and expression body
* Specifying/removing an explicit return type

```kotlin
// [Before]

fun sum(a: Int, b: Int): Int {
    return a + b
}

// [After]
fun sum(a: Int, b: Int) = a + b
```

Same applies for `if` and `when`, as these are expressions in Kotlin

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

Overloading methods with the reduced number of arguments can be avoided by providing *default values* for parameters

```kotlin
// [Before]
fun printNumber() = printNumber(0)
fun printNumber(a: Int) = println("Number: $a")

// [After]
fun printNumber(a: Int = 0) = println("Number: $a")
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

## When expressions
### Type check

Type checks can be used in `when` expressions

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

Destructure a map to use key and value directly

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

