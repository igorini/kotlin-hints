package com.igorini.kotlin.hints.maps

// [Traversing by key and value] -> Destructure a map to use key and value directly

// [Before]
fun beforeTraverse(map: Map<Any, Any>) {
    for (entry in map) {
        println("${entry.key} -> ${entry.value}")
    }
}

// [After]
fun afterTraverse(map: Map<Any, Any>) {
    for ((k, v) in map) {
        println("$k -> $v")
    }
}