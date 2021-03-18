package com.markov.a03_exceptions

import kotlin.random.Random

class Fish constructor(
    e: Int,
    w: Int
): Animal(e, w, "Fishka") {

    override val maxAge =10

    override fun move() {
        super.move()
        println("$name плывет")
    }

    override fun makeChild(): Fish {
        val childEnergy = Random.nextInt(10) +1
        val childWeight = Random.nextInt(5) +1
        val child = Fish(childEnergy, childWeight)
        println("Было рождено животное ${child.toString()}")
        return child
    }
}