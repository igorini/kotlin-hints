package com.igorini.kotlin.hints.lang

// [Iteration up to an exclusive upper limit] -> Use `until` operator

const val LIMIT = 10

// [FROM]
fun fromUpperLimit(){
    for (i in 1..(com.igorini.kotlin.hints.lang.LIMIT - 1)) println(i)
}

// [TO]
fun toUpperLimit() {
    for (i in 1 until com.igorini.kotlin.hints.lang.LIMIT) println(i)
}