package com.markov.extensions_objects_enums

fun main() {

    println("Введите количество воинов в команде")
    val numberOfWarrior = readLine()?.toIntOrNull() ?: return

    val team1 = Team(numberOfWarrior)
    val team2 = Team(numberOfWarrior)
    val battle = Battle(team1, team2)
    var i = 0

    while (!battle.battleIsOver()) {
        battle.getNextBattleState()
        println("Состояние битвы ${battle.getBattleState()}")
        i++
    }
    println("Битва закончилась ${battle.getBattleState()}")
}