package com.igorini.kotlin.hints.imports

import java.util.*

// [Name clash] -> Avoid writing a fully qualified name for the class in the scenario of an import name clash
// by disambiguating a class with a keyword `as`

import java.sql.Date as SqlDate

// [Before]
fun beforeNameClash() {
    val utilDate: Date
    val sqlDate: java.sql.Date
}

// [After]
fun afterNameClash() {
    val utilDate: Date
    val sqlDate: SqlDate
}