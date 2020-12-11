package com.markov.extensions_objects_enums

interface Warrior {

    val isKilled: Boolean
    val chanceToAvoidBeingHit: Int

    fun toAttack(Warrior: Warrior)

    fun takеDamage (damage: Int)
}