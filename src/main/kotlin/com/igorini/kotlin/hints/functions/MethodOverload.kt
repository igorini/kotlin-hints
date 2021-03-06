package com.igorini.kotlin.hints.functions

// [Method Overload] -> Overloading methods with the reduced number of arguments can be avoided by providing default values for parameters

// [Before]
fun beforePrintNumber() = beforePrintNumber(0)
fun beforePrintNumber(a: Int) = println("Number: $a")

// [After]
fun afterPrintNumber(a: Int = 0) = println("Number: $a")