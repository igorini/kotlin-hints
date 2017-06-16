package com.igorini.kotlin.hints.functions

// [Single expression (e.g IF) in a functions] -> Replace the functions block with an expression body

// [FROM]
fun fromMaxOf(a: Int, b: Int): Int {
    if (a > b) {
        return a;
    }
    return b;
}

// [TO]
fun toMaxOf(a: Int, b: Int) = if (a > b) a else b
