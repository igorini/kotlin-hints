package com.igorini.kotlin.hints.functions

// [Method Overload] -> Method overloads can be avoided by providing default values for parameters

// [FROM]
fun fromPrintNumber() = fromPrintNumber(0)
fun fromPrintNumber(a: Int) = println("Number: $a")

// [TO]
fun toPrintNumber(a: Int = 0) = println("Number: $a")