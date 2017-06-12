package com.igorini.kotlin.hints.lang

// [Iterate up-to some value but not including it] -> Use `until` operator

val limit = 10

// [FROM]
fun fromUpperLimit(){
    for (i in 1..(com.igorini.kotlin.hints.lang.limit - 1)) println(i)
}

// [TO]
fun toUpperLimit() {
    for (i in 1 until com.igorini.kotlin.hints.lang.limit) println(i)
}