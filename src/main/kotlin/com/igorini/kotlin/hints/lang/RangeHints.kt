package com.igorini.kotlin.hints.lang

// [Exclusive upper limit] -> Use `until` operator to exclude the upper limit.

// Printing out numbers from 1 up to but excluding 10

const val LIMIT = 10

// [FROM]
fun fromUpperLimit(){
    for (i in 1..(LIMIT - 1)) println(i)
}

// [TO]
fun toUpperLimit() {
    for (i in 1 until LIMIT) println(i)
}