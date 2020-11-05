package com.markov.basemethodsandpropertydelegates

fun main() {
    val user = Person (190, 85, "Nikita")
    val user2 = Person ( 190, 85, "Nikita")

    val hashSet = HashSet <Person>()
    hashSet.add (user)
    hashSet.add(user2)

    println(hashSet.count())
}