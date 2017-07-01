package com.igorini.kotlin.hints.ifs

/* [If not null] -> Could be replaced with a safe access expression.
 *
 * NB: Intellij IDEA has intentions for converting between these two idioms.
 */

// [Before]
fun beforeMiddleNameLength(middleName: String?) = if (middleName != null) middleName.length else null

// [After]
fun afterMiddleNameLength(middleName: String?) = middleName?.length