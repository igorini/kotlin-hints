package com.igorini.kotlin.hints.extensions

// [Extension Property] -> Commonly used expressions made on a class property can be added to a class as an extension property instead.

val list = listOf(1, 2)

// [Before]
fun beforeExtensionProperty() {
    println("Last index: ${list.size - 1}")
}

// [After]
val <T> List<T>.lastIndex: Int
    get() = size - 1

fun afterExtensionProperty() {
    println("Last index: ${list.lastIndex}")
}