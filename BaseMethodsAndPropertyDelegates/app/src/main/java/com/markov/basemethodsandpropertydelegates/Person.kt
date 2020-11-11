package com.markov.basemethodsandpropertydelegates

import com.google.android.material.chip.ChipDrawable
import kotlin.random.Random
import kotlin.reflect.KProperty

class Person constructor(
    val height: Int,
    val weight: Int,
    val name: String

) {
    val pets: HashSet<Animal> by ReadOnlyPropertyDelegate()

    fun buyPet() {
        pets.add(Animal (Random.nextInt(), Random.nextInt(), "Barsik"))
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Person

        if (height != other.height) return false
        if (weight != other.weight) return false
        if (name != other.name) return false
        if (pets != other.pets) return false

        return true
    }

    override fun hashCode(): Int {
        var result = height
        result = 31 * result + weight
        result = 31 * result + name.hashCode()
        result = 31 * result + pets.hashCode()
        return result
    }

    override fun toString(): String {
        return "Person(height=$height, weight=$weight, name='$name', pets=$pets)"
    }

}
