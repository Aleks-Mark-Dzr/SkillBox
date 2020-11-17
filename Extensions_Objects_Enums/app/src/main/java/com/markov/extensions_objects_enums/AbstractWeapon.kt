package com.markov.extensions_objects_enums

abstract class AbstractWeapon(
    val maxQuantityAmmo: Int,
    val fireType: FireType
) {
    var currentListAmmo: MutableList<Ammo> = mutableListOf<Ammo>()
    val availabilityAmmo: Boolean = currentListAmmo.isNotEmpty()

    abstract fun createAmmo(): Ammo

    fun recharge() {
        currentListAmmo = mutableListOf()
        for (i in 1..maxQuantityAmmo) {
            currentListAmmo.add(createAmmo())
        }
    }

    fun getAmmo(): Ammo {
        currentListAmmo.last()
        return currentListAmmo.removeLast()
    }

    object Weapons {

        val pistol: AbstractWeapon = AbstractWeapon.Weapons.createPistol()

        fun createPistol(): AbstractWeapon {
            return object: AbstractWeapon(20, FireType.SingleShot){
                override fun createAmmo(): Ammo {
                    return Ammo.AMMO762x39BP
                }

            }

        }

        fun createFifle(): AbstractWeapon {
            return object: AbstractWeapon (10, FireType.SingleShot) {
                override fun createAmmo(): Ammo {
                    return Ammo.AMMO762x39PS
                }

            }
        }

        fun createSniperRifle(): AbstractWeapon {
            return object: AbstractWeapon(10, FireType.SingleShot){
                override fun createAmmo(): Ammo {
                    return Ammo.AMMO762x39BP
                }

            }
        }

        fun createMachineGun(): AbstractWeapon {
            return object: AbstractWeapon(100, FireType.BurstShooting(firingBurstSize = 3)){
                override fun createAmmo(): Ammo {
                    return Ammo.AMMO762x39NR
                }

            }
        }

    }
}