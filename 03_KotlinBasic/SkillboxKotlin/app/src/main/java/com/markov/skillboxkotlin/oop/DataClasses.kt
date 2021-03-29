package com.markov.skillboxkotlin.oop

import com.markov.skillboxkotlin.User

fun main() {

    val user1 = User("name1", "lastname1")
    user1.innerState = "state1"
    val user2 = User("name1", "lastname1")
    user2.innerState = "state2"

    println(user1 == user2)

    val user3 = user1.copy(lastName = "copiedLastName")
    println("user3 inner state = ${user3.innerState}")

    println(user1)

    val (name, lastname) = User("name5", "lastname5")
    println("name = ${name}")
    println("lastname = ${lastname}")

    val users = listOf(
        user1,
        user2,
        user3
    )

    users.forEach { (a, b) -> println("$a")}

    val map = mapOf(
        1 to "1",
        2 to "2"
    )

    for ((key, value) in map) {
        key
        value
    }

}