package com.igorini.kotlin.hints.functions

// [Single line in a functions] -> Replace the functions block with an expression body

// [FROM]
fun fromSum(a: Int, b: Int): Int {
    return a + b;
}

// [TO]
fun toSum(a: Int, b: Int) = a + b