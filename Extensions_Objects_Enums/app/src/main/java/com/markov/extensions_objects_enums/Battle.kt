package com.markov.extensions_objects_enums

class Battle(
    val team1: Team,
    val team2: Team
) {
    fun battleIsOver(): Boolean = !(getBattleState() is SealedStateOfBattle.Progress)

    fun getBattleState(): SealedStateOfBattle {
        println("team1 current Helth level: ${team1.team.map { it.currentHealthLevel }}")
        println("team2 current Helth level: ${team2.team.map { it.currentHealthLevel }}")
        println("team1 is alive = ${team1.isAlive()}")
        println("team2 is alive = ${team2.isAlive()}")
//        println("battle is over?: ${battleIsOver()}")
        if (team1.isAlive() && team2.isAlive()) {
            return SealedStateOfBattle.Progress(
                team1Health = team1.getCurrentHealth(),
                team2Health = team1.getCurrentHealth()
            )
        } else if (!team1.isAlive() && !team2.isAlive()) {
            return SealedStateOfBattle.draw
        } else if (!team1.isAlive()) {
            return SealedStateOfBattle.team2won
        } else {
            return SealedStateOfBattle.team1won
        }

    }

    fun getNextBattleState() {
        team1.team.shuffled()
        team2.team.shuffled()

        for (i in 0 until team1.team.size) {
            val currentWarrior1: AbstractWarrior = team1.team.get(i)
            val currentWarrior2: AbstractWarrior = team2.team.get(i)
            if (!currentWarrior1.isKilled) {
                if (!currentWarrior2.isKilled) {
                    currentWarrior1.takeDamageForWarrior(currentWarrior2)
                } else {
                    team2.team.firstOrNull { !it.isKilled }
                        ?.let { currentWarrior1.takeDamageForWarrior(it) }
                }
            }

            if (!currentWarrior2.isKilled) {
                if (!currentWarrior1.isKilled) {
                    currentWarrior2.takeDamageForWarrior(currentWarrior1)
                } else {
                    team1.team.firstOrNull { !it.isKilled }
                        ?.let { currentWarrior2.takeDamageForWarrior(it) }
                }
            }
        }
    }
}