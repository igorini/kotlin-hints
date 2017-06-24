package com.igorini.kotlin.hints.lambdas

/* [Single parameter] -> Could use an implicit name `it` to simplify an expression.
 *
 * NB: Intellij IDEA has an intention that performs the following transformation.
 */

// [Before]
fun beforePositive(numbers: List<Int>) = numbers.filter { n -> n > 0 }

// [After]
fun afterPositive(numbers: List<Int>) = numbers.filter { it > 0 }