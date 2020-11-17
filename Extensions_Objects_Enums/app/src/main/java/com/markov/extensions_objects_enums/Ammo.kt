package com.markov.extensions_objects_enums

import kotlin.random.Random

enum class Ammo (

    val damage: Int,
    val criticalDamageChance: Int,
    val criticalDamageRatio: Int

) {
    AMMO762x39PS(60, 30, 50),
    AMMO762x39BP(48, 36, 70),
    AMMO762x39NR(72, 24, 40);


    fun calculateDamage(): Int {
        return if (criticalDamageChance.isChanceSolved()) {
            damage * criticalDamageRatio
        } else {
            damage
        }
    }
}