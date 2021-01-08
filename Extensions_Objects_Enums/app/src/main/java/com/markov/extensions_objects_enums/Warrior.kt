package com.markov.extensions_objects_enums

interface Warrior {

    var isKilled: Boolean
    val chanceToAvoidBeingHit: Int

    fun toAttack(Warrior: Warrior)

    fun takеDamage (damage: Int)
}