package com.markov.a04_battle

import kotlin.random.Random

enum class Ammo(

    val damage: Int,
    val criticalDamageChance: Int,
    val criticalDamageRatio: Int

) {
    AMMO762x39PS(60, 30, 50),
    AMMO762x39BP(48, 36, 70),
    AMMO762x39NR(72, 24, 40)

}

fun Ammo.calculateDamage(): Int {
    val chance = Random.nextInt(100)
    if (chance < criticalDamageChance) {
        return damage * criticalDamageRatio
    } else {
        return damage
    }
}