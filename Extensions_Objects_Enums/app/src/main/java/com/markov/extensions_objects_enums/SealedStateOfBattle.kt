package com.markov.extensions_objects_enums

sealed class SealedStateOfBattle {
    class Progress(
        val Team1Health: Int,
        val Team2Health: Int
    ): SealedStateOfBattle()
    object team1won: SealedStateOfBattle()
    object team2won: SealedStateOfBattle()
    object draw: SealedStateOfBattle()

}