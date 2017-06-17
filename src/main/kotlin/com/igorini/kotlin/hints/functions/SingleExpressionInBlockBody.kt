package com.igorini.kotlin.hints.functions

/* [Single expression in a block body] -> Could be converted to the expression body. Return type could be inferred.
 *
 * NB: Intellij IDEA has intentions for:
 * converting between a block and expression body
 * specifying/removing an explicit return type
 */

// [FROM]

fun fromSum(a: Int, b: Int): Int {
    return a + b;
}

// [TO]
fun toSum(a: Int, b: Int) = a + b

// -----
// Same applies for `if` and `when`, as they are expressions in Kotlin

// [FROM]
fun fromMaxOf(a: Int, b: Int): Int {
    return if (a > b) a else b
}

// [TO]
fun toMaxOf(a: Int, b: Int) = if (a > b) a else b

// -----

// [FROM]
fun fromCountryCode(country: String): String {
    return when(country){
        "China" -> "CHN"
        "Japan" -> "JPN"
        else -> throw UnsupportedOperationException("Unknown country: $country")
    }
}

// [TO]
fun toCountryCode(country: String) = when(country){
    "China" -> "CHN"
    "Japan" -> "JPN"
    else -> throw UnsupportedOperationException("Unknown country: $country")
}