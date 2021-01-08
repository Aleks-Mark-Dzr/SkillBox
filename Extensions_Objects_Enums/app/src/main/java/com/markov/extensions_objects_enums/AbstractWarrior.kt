package com.markov.extensions_objects_enums

abstract class AbstractWarrior(
    val maxHealth: Int,
    override val chanceToAvoidBeingHit: Int,
    val hitProbability: Int,
    val weapon: AbstractWeapon,
) : Warrior {

    var currentHealthLevel: Int = maxHealth
        set(value) {
            if(value <= 0) {
                isKilled = true
            }
            field = value
        }

    override fun toAttack(warrior: Warrior) {
        return if (!weapon.availabilityAmmo) {
            weapon.recharge()
        } else {
            if (weapon.fireType is FireType.SingleShot) {
                takeDamageForWarrior(warrior)
            } else {
                val firingBurstSize =
                    (weapon.fireType as? FireType.BurstShooting)?.firingBurstSize ?: 1
                for (i in 1..firingBurstSize) {
                    if (weapon.availabilityAmmo) {
                        takeDamageForWarrior(warrior)
                    }
                }
            }
        }
    }

    fun takeDamageForWarrior(warrior: Warrior) {
        val current = weapon.getAmmo()
        if (hitProbability >= warrior.chanceToAvoidBeingHit && current != null) {
            val damage: Int = current.calculateDamage()
            warrior.takеDamage(damage)
        }
    }

    override fun takеDamage(damage: Int) {
        currentHealthLevel = currentHealthLevel - damage
    }
}