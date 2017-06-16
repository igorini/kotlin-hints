package com.igorini.kotlin.hints.functions

// [Method Overload] -> Method overloads might be avoided by providing default values for parameters

// [FROM]
fun fromFoo() = com.igorini.kotlin.hints.functions.fromFoo(0, "")
fun fromFoo(a: Int) = com.igorini.kotlin.hints.functions.fromFoo(a, "")
fun fromFoo(b: String) = com.igorini.kotlin.hints.functions.fromFoo(0, b)
fun fromFoo(a: Int, b: String) = println("a: $a. b: $b")

// [TO]
fun toFoo(a: Int = 0, b: String = "") = println("a: $a. b: $b")