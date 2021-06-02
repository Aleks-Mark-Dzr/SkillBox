package com.markov.skillboxtraning

fun main() {
    val users = listOf(
            User("Vasya", "Sergeev", 30),
            User("Vasya", "Ivanov", 20),
            User("Vasya", "Petrov", 10),
            User("Vasya", "Sidorov", 50)
    )
    val user1 = users[0]
    val oldestUser = users.maxBy { user -> user1.age.let { it + 1 } }
    val maxNameUser = users.maxBy(User::getFullnameLegth)
    println(maxNameUser)
}