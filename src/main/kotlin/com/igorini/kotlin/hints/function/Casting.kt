package com.igorini.kotlin.hints.function

// [IS (INSTANCEOF)] -> Cast happens automatically

fun toLength(obj: Any) = (obj as? String)?.length ?: 0