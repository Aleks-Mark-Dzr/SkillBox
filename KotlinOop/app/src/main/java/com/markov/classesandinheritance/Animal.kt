package com.markov.classesandinheritance

import kotlin.random.Random

class Animal constructor(

    e: Int,
    w: Int,
    private val maximumAge: Int = 15,
    val name: String = "Jey"
) {
    var energy: Int = e
        private set
    var weight: Int = w
        private set
    var age: Int = 0
        private set
    val isTooOld: Boolean
        get() = age >= maximumAge

    fun sleep() {
        if (isTooOld || energy == 0 || weight <= 1) {
            return
        }

        energy += 5
        age++
        println("$name спит")
    }

    fun eat() {
        if (isTooOld || energy == 0 || weight <= 1) {
            return
        }

        energy += 3
        weight++
        incrementAgeSometimes()
        println("$name ест")
    }

    private fun incrementAgeSometimes() {
        if (Random.nextBoolean()) {
            age++
        }
    }

    fun move() {
        if (isTooOld || energy == 0 || weight <= 1) {
            return
        }

        energy -= 5
        weight--
        incrementAgeSometimes()
        println("$name двигается")
    }

    fun makeChild(): Animal {
        val childEnergy = Random.nextInt(10) +1
        val childWeight = Random.nextInt(5) +1
        val child = Animal(childEnergy, childWeight, maximumAge, name)
        println("Было рождено животное ${child.toString()}")
        return child
    }

    override fun toString(): String {
        return "Animal(maximumAge=$maximumAge, name='$name', energy=$energy, weight=$weight, age=$age)"
    }


}

