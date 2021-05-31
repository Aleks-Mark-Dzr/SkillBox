package com.markov.extensions_objects_enums

import kotlin.random.Random

class Team(
    count: Int
) {
    val team: List<AbstractWarrior> = createTeam(count)

    fun createTeam(count: Int): List<AbstractWarrior> {
        val list: MutableList<AbstractWarrior> = mutableListOf()

        for (i in 0 until count) {
            val probability = Random.nextInt(100)
            when (probability) {
                in 0..10 -> list.add(General())
                in 11..40 -> list.add(Captain())
                else -> list.add(Soldier())
            }
        }
        println("Создана команда $list")
        return list
    }

    fun isAlive(): Boolean {
        return getCurrentHealth() > 0
    }

    fun getCurrentHealth(): Int {
        return team.filter { it.currentHealthLevel > 0 }.sumBy { it.currentHealthLevel }
    }
}
