package com.igorini.kotlin.hints.maps

// [Traversing by key and value] -> Destructure a map to use key and value directly

// [Before]
fun beforeTraverse(map: Map<Any, Any>) {
    map.forEach { entry -> println("${entry.key} -> ${entry.value}") }
}

// [After]
fun afterTraverse(map: Map<Any, Any>) {
    map.forEach { (k, v) -> println("$k -> $v") }
}