package com.markov.extensions_objects_enums

abstract class AbstractWarrior(
    val maxHealth: Int,
    override val chanceToAvoidBeingHit: Int,
    val hitProbability: Int,
    val weapon: AbstractWeapon,
) : Warrior {

    var currentHealthLevel: Int = maxHealth

    override fun toAttack(warrior: Warrior) {
        return if (!weapon.availabilityAmmo) {
            weapon.recharge()
        } else {
            for (i in 1..weapon.maxQuantityAmmo){
                val ammo = weapon.getAmmo()
                if (hitProbability >= warrior.chanceToAvoidBeingHit) {
                    val damage: Int = ammo.calculateDamage()
                    warrior.takеDamage(damage)
                }

            }
        }
    }

    override fun takеDamage(damage: Int) {
        currentHealthLevel = currentHealthLevel - damage
    }
}