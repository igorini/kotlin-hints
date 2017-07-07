package com.igorini.kotlin.hints.dataclasses

// [Destructure] -> Could destructure a data class when only it's internals are used within a scope.

data class User(val name: String = "", val age: Int = 0)

val alice = User("Alice", 22)
val ageLimit = 18

// [Before]
fun beforeDestructure() {
    println("Name: $alice.name, Age: $alice.age")
    if (alice.age >= ageLimit) println("$alice.name is over $ageLimit")
}

// [After]
fun afterDestructure() {
    val (name, age) = alice
    println("Name: $name, Age: $age")
    if (age >= ageLimit) println("$name is over $ageLimit")
}