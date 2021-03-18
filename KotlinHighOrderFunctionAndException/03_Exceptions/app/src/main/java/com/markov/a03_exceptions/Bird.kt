package com.markov.a03_exceptions

import kotlin.random.Random

class Bird constructor(
    e: Int,
    w: Int
): Animal(e, w, "Ptaha"), Soundable {

    override val maxAge = 20

    override fun move () {
        super.move()
        println("$name летит")
    }

    override fun makeChild(): Bird {
        val childEnergy = Random.nextInt(10) +1
        val childWeight = Random.nextInt(5) +1
        val child = Bird(childEnergy, childWeight)
        println("Было рождено животное ${this.toString()}")
        return child
    }

    override fun makeSound() {
        println("Чик-чирик")
    }

}