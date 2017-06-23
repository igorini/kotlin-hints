package com.igorini.kotlin.hints.`when`

// [Type check] -> Type checks can be used in `when` expressions

// [Before]
fun beforePrintWithType(obj: Any) {
    if (obj is String) {
        println("Text: $obj")
    } else if (obj is Number) {
        println("Number: $obj")
    } else {
        println("Unknown: $obj")
    }
}

// [After]
fun afterPrintWithType(obj: Any) = when (obj) {
    is String -> println("Text: $obj")
    is Number -> println("Number: $obj")
    else -> println("Unknown: $obj")
}