package com.markov.classesandinheritance

import kotlin.random.Random

class Dog constructor(
    e: Int,
    w: Int
) : Animal(e, w, "Muhtar"), Soundable {

    override val maxAge = 22

    override fun move() {
        super.move()
        println("$name бежит")
    }

    override fun makeChild(): Dog {
        val childEnergy = Random.nextInt(10) + 1
        val childWeight = Random.nextInt(5) + 1
        val child = Dog(childEnergy, childWeight)
        println("Было рождено животное ${this.toString()}")
        return child
    }

    override fun makeSound() {
        println("гав-гав")
    }
}