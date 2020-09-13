package com.markov.basicsyntax

fun main() {

    val myFirstName: String = "Aleksei"
    val myLastName: String = "Markov"
    val myHeight: Int = 174
    val myWeight: Int = 60


    val fisrtName: String = myFirstName
    val lastName: String = myLastName
    var height: Int = myHeight
    val weight: Int = myWeight
    var isChaild: Boolean = height < 150 || weight < 40

    var info: String = "First name: $fisrtName,\n Last name: $lastName,\n Height: $height,\n Weight: $weight,\n is chaild: $isChaild"

    println (info)
}