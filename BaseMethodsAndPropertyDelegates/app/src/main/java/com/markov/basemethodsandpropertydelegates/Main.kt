package com.markov.basemethodsandpropertydelegates

fun main() {

    val person1 = Person(190, 85, "Nikita")

    val hashSet = HashSet <Person>()
    hashSet.add (person1)
    hashSet.add (Person(190, 85, "Nikita"))
    hashSet.add (Person(180, 75, "Sasha"))

    println(hashSet.count())
    println(hashSet.toString())
    person1.buyPet()
    person1.buyPet()
}