package com.markov.extensions_objects_enums

import kotlin.random.Random

class Team(
    count: Int
) {
    val team: List<Warrior> = createTeam(count)

    fun createTeam(count: Int): List<Warrior> {
        val list: MutableList<Warrior> = mutableListOf()

        for (i in 0..count) {
            val probability = Random.nextInt(100)
            when(probability){
                in 0..10 -> list.add(General())
                in 11..40 -> list.add(Captain())
                else -> list.add(Soldier())
            }
        }
        return list
    }
}
