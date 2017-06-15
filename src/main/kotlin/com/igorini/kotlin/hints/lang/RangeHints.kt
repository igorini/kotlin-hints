package com.igorini.kotlin.hints.lang

// [Iteration up to an exclusive upper limit] -> Use `until` operator

const val LIMIT = 10

// [FROM]
fun fromUpperLimit(){
    for (i in 1..(LIMIT - 1)) println(i)
}

// [TO]
fun toUpperLimit() {
    for (i in 1 until LIMIT) println(i)
}