package com.igorini.kotlin.hints.extensions

// [Utility class] -> Utility class could be replaced with function extensions

// [Before]
class StringUtils {
    fun swapCase(str: String): String {
        return "$str swapped"
    }
}

// [After]
fun String.swapCase(): String {
    return "$this swapped"
}
