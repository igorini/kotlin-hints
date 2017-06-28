package com.igorini.kotlin.hints.with

// [Multiple method calls on an object] -> `with` expression could be used.

// [Before]
fun beforePrintMenu(pizzas: List<String>) {
    pizzas.forEach { println("Large $it") }
    pizzas.forEach { println("Medium $it") }
    pizzas.forEach { println("Small $it") }
}

// [After]
fun afterPrintMenu(pizzas: List<String>) = with(pizzas) {
    forEach { println("Large $it") }
    forEach { println("Medium $it") }
    forEach { println("Small $it") }
}