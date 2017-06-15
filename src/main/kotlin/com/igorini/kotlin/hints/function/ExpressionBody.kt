package com.igorini.kotlin.hints.function

// [Single line in a function] -> Replace the function block with an expression body

// [FROM]
fun fromSum(a: Int, b: Int): Int {
    return a + b;
}

// [TO]
fun toSum(a: Int, b: Int) = a + b

// ----------------------------------------------------------------------------

// [Single expression (e.g IF) in a function] -> Replace the function block with an expression body

// [FROM]
fun fromMaxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a;
    } 
    return b;
}

// [TO]
fun toMaxOf(a: Int, b: Int) = if (a > b) a else b