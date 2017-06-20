package com.igorini.kotlin.hints.ranges

// [Exclusive upper limit] -> Use `until` operator to exclude the upper limit.

// Printing out numbers from 1 up to but excluding 10 (half-open range)

const val LIMIT = 10

// [Before]
fun beforeUpperLimit(){
    for (i in 1..(LIMIT - 1)) println(i)
}

// [After]
fun afterUpperLimit() {
    for (i in 1 until LIMIT) println(i)
}