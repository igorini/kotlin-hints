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
  * [Functions](#functions)
     * [Single expression in a block body](#single-expression-in-a-block-body)
     * [Method overload](#method-overload)
  * [When expressions](#when-expressions)
     * [Type check](#type-check)
  * [Maps](#maps)
     * [Traverse keys and values](#traverse-keys-and-values)
  * [Ranges](#ranges)
     * [Exclusive upper limit](#exclusive-upper-limit)


## Functions
### Single expression in a block body

Could be converted to the expression body. Return type could then be inferred.

**NB**: Intellij IDEA has intentions for:
* Converting between a block and expression body
* Specifying/removing an explicit return type

```kotlin
// [Before]

fun beforeSum(a: Int, b: Int): Int {
    return a + b
}

// [After]
fun afterSum(a: Int, b: Int) = a + b
```

Same applies for `if` and `when`, as these are expressions in Kotlin

```kotlin
// [Before]
fun beforeMaxOf(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// [After]
fun afterMaxOf(a: Int, b: Int) = if (a > b) a else b
```

```kotlin
// [Before]
fun beforeCountryCode(country: String): String {
    return when(country){
        "China" -> "CHN"
        "Japan" -> "JPN"
        else -> throw UnsupportedOperationException("Unknown country: $country")
    }
}

// [After]
fun afterCountryCode(country: String) = when(country){
    "China" -> "CHN"
    "Japan" -> "JPN"
    else -> throw UnsupportedOperationException("Unknown country: $country")
}
```

### Method overload

Overloading methods with the reduced number of arguments can be avoided by providing *default values* for parameters

```kotlin
// [Before]
fun beforePrintNumber() = beforePrintNumber(0)
fun beforePrintNumber(a: Int) = println("Number: $a")

// [After]
fun afterPrintNumber(a: Int = 0) = println("Number: $a")
```

## When expressions
### Type check

Type checks can be used in `when` expressions

```kotlin
// [Before]
fun beforePrintWithType(obj: Any) {
    if (obj is String) {
        println("Text: $obj")
    } else if (obj is Number) {
        println("Number: $obj")
    } else {
        println("Unknown: $obj")
    }
}

// [After]
fun afterPrintWithType(obj: Any) = when (obj) {
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
for (entry in map) {
    println("${entry.key} -> ${entry.value}")
}

// [After]
for ((k, v) in map) {
    println("$k -> $v")
}
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

