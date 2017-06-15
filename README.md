#  kotlin-hints

kotlin-hints is a collection of Kotlin patterns and hints.

Writing idiomatic Kotlin code can be hard, especially when just learning the language. More importantly, it's not always clear in which ways can existing Kotlin code be improved to become either shorter, faster, more readable or more maintainable.

There are good tools which help with that, including Intellij IDEA inspections and [detekt](https://github.com/arturbosch/detekt), the static code analysis tool.

This project attempts to list the patterns which are not covered by the above tools. Some of the patterns are not covered by these tools by design, however the list will also contain the items which are not yet implemented.

Most of the examples are taken from the [Kotlin Language Reference](https://kotlinlang.org/docs/reference/)

---

**Table of Contents**

   * [kotlin-hints](#kotlin-hints)
      * [Ranges](#ranges)
         * [Exclusive upper limit](#exclusive-upper-limit)

## Ranges
### Exclusive upper limit

Use `until` operator to exclude the upper limit.

```kotlin
// Printing out numbers from 1 up to but excluding 10

const val LIMIT = 10

// [FROM]
for (i in 1..(LIMIT - 1)) println(i)

// [TO]
for (i in 1 until LIMIT) println(i)
```

