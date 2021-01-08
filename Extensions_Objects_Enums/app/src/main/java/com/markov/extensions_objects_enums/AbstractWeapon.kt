package com.markov.extensions_objects_enums

abstract class AbstractWeapon(
    val maxQuantityAmmo: Int,
    val fireType: FireType
) {
    var currentListAmmo: MutableList<Ammo> = mutableListOf<Ammo>()
    val availabilityAmmo: Boolean = currentListAmmo.isNotEmpty()

    init {
        recharge()
    }

    abstract fun createAmmo(): Ammo

    fun recharge() {
//        println("$this recharge")
//        println("Количество патронов ${currentListAmmo.size}")
        currentListAmmo = mutableListOf()
        for (i in 1..maxQuantityAmmo) {
            currentListAmmo.add(createAmmo())
        }
//        println("Количество патронов ${currentListAmmo.size}")
    }

    fun getAmmo(): Ammo? {
//        println("$this getAmmo")
//        println("Количество патронов ${currentListAmmo.size}")
        if (currentListAmmo.isEmpty()) {
            recharge()
            return null
        } else
        return currentListAmmo.removeLast()
    }

    object Weapons {

        fun createPistol(): AbstractWeapon {
//            println("CreatePictol, maxQuantityAmmo = 20")
            return object : AbstractWeapon(20, FireType.SingleShot) {
                override fun createAmmo(): Ammo {
                    return Ammo.AMMO762x39BP
                }

            }

        }

        fun createRifle(): AbstractWeapon {
//            println("CreateRifle, maxQuantityAmmo = 10")
            return object : AbstractWeapon(10, FireType.SingleShot) {
                override fun createAmmo(): Ammo {
                    return Ammo.AMMO762x39PS
                }

            }
        }

        fun createSniperRifle(): AbstractWeapon {
//            println("CreateSniperRifle, maxQuantityAmmo = 10")
            return object : AbstractWeapon(10, FireType.SingleShot) {
                override fun createAmmo(): Ammo {
                    return Ammo.AMMO762x39BP
                }

            }
        }

        fun createMachineGun(): AbstractWeapon {
//            println("CreateMachineGun, maxQuantityAmmo = 100")
            return object : AbstractWeapon(100, FireType.BurstShooting(firingBurstSize = 3)) {
                override fun createAmmo(): Ammo {
                    return Ammo.AMMO762x39NR
                }

            }
        }

    }
}