package com.markov.extensions_objects_enums

sealed class FireType {

    object SingleShot: FireType()
    data class BurstShooting (
        val firingBurstSize: Int
    ): FireType ()

}