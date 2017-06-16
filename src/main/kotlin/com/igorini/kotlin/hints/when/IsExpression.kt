package com.igorini.kotlin.hints.`when`

// [When] -> Allows to have `is` expressions

fun whenIs(obj: Any) = when (obj) {
    1 -> "One"
    "Hello" -> "Greeting"
    is Long -> "Long"
    else -> ""
}