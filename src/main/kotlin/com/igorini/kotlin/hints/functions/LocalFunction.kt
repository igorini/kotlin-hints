package com.igorini.kotlin.hints.functions

import java.math.BigDecimal

// [Local Function] -> Functions can be nested. Inner function can access local variables of an outer function.
// Could be used when a helper function should be only visible to a single caller.

// [Before]
fun beforePrintReceipt(name: String, price: BigDecimal, bonusPoints: Int) {
    beforePrintProduct(name, price)
    beforePrintDiscount(bonusPoints)
}

fun beforePrintProduct(name: String, price: BigDecimal) = println("Name: $name, Price: $price")

fun beforePrintDiscount(bonusPoints: Int) = println("Collected $bonusPoints bonus points")

// [After]
fun afterPrintReceipt(name: String, price: BigDecimal, bonusPoints: Int) {
    fun afterPrintProduct() = println("Name: $name, Price: $price")
    fun afterPrintDiscount() = println("Collected $bonusPoints bonus points")

    afterPrintProduct()
    afterPrintDiscount()
}