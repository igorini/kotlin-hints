package com.igorini.kotlin.hints.functions

// [Infix Function] -> Allows using functions in the form of `a rem b` instead of `a.rem(b)`.

// [Before]
fun beforeInfix() = 1.rem(2)

// [After]
infix fun Int.rem(num: Int) = this.rem(num)
fun afterInfix() = 1 rem 2