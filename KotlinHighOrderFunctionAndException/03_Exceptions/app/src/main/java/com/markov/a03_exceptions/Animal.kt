package com.markov.a03_exceptions

import kotlin.random.Random

abstract class Animal constructor(

    val e: Int,
    val w: Int,
    val name: String = "Jey"
) : AgedAnimal() {
    var energy: Int = e
        private set
    var weight: Int = w
        private set
    var age: Int = 0
        private set
    val isTooOld: Boolean
        get() = age >= maxAge

    fun sleep() {
        if (isTooOld || energy <= 0 || weight <= 1) {
            return
        }

        energy += 5
        age++
        println("$name спит")
    }

    fun eat() {
        if (isTooOld || energy <= 0 || weight <= 1) {
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

    open fun move() {
        if (isTooOld || energy <= 0 || weight <= 1) {
            return
        }

        energy -= 5
        weight--
        incrementAgeSometimes()
        println("$name двигается")
    }

    open fun makeChild(): Animal {
        return object: Animal (e, w, "Jey"){
            override val maxAge = this@Animal.maxAge
        }
    }

    override fun toString(): String {
        return "Animal(maximumAge=$maxAge, name='$name', energy=$energy, weight=$weight, age=$age)"
    }

}