package com.markov.basemethodsandpropertydelegates

fun main() {

    val hashSet = HashSet<Person>()
    hashSet.add(Person(190, 85, "Nikita"))
    hashSet.add(Person(190, 85, "Nikita"))
    hashSet.add(Person(180, 75, "Sasha"))

    println(hashSet.count())
    hashSet.forEach {
        it.buyPet()
        it.buyPet()
        it.buyPet()
        it.pets
    }
}