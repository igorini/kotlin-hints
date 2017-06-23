package com.igorini.kotlin.hints.functions

/* [Single expression in a block body] -> Could be converted to the expression body. Return type could then be inferred.
 *
 * NB: Intellij IDEA has intentions for:
 * converting between a block and expression body
 * specifying/removing an explicit return type
 */

// [Before]

fun beforeSum(a: Int, b: Int): Int {
    return a + b
}

// [After]
fun afterSum(a: Int, b: Int) = a + b

// -----
// Same applies for `if` and `when`, as these are expressions in Kotlin

// [Before]
fun beforeMaxOf(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// [After]
fun afterMaxOf(a: Int, b: Int) = if (a > b) a else b

// -----

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