package com.markov.extensions_objects_enums

import kotlin.random.Random

fun Int.isChanceSolved(): Boolean{

    val chance = Random.nextInt(100)
    return chance > this

}