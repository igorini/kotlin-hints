package com.igorini.kotlin.hints.functions

// [Named Arguments] -> Function parameters can be named when calling a function.

fun reformat(str: String,
             normalizeCase: Boolean = true,
             upperCaseFirstLetter: Boolean = true,
             divideByCamelHumps: Boolean = false,
             wordSeparator: Char = ' ') = println("reformat")

// [Before]

fun beforeNamedArguments() = reformat("hello,world", false, false, true, ',')

// [After]
fun afterNamedArguments() = reformat("hello,world", normalizeCase = false, upperCaseFirstLetter = false, divideByCamelHumps = true, wordSeparator = ',')
