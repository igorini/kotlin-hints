package com.igorini.kotlin.hints.lang

// [Traversing by key and value] -> Destructure a map

// [FROM]
fun fromTraverse(map: Map<Any, Any>) {
    for (entry in map) {
        println("${entry.key} -> ${entry.value}")
    }
}

// [TO]
fun toTraverse(map: Map<Any, Any>) {
    for ((k, v) in map) {
        println("$k -> $v")
    }
}