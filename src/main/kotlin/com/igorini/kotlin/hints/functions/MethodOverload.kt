package com.igorini.kotlin.hints.functions

// [Method Overload] -> Method overloads can be avoided by providing default values for parameters

// [FROM]
fun fromPrintNumberAndText() = fromPrintNumberAndText(0, "")
fun fromPrintNumberAndText(a: Int) = fromPrintNumberAndText(a, "")
fun fromPrintNumberAndText(b: String) = fromPrintNumberAndText(0, b)
fun fromPrintNumberAndText(a: Int, b: String) = println("Number: $a. Text: $b")

// [TO]
fun toPrintNumberAndText(a: Int = 0, b: String = "") = println("Number: $a. Text: $b")