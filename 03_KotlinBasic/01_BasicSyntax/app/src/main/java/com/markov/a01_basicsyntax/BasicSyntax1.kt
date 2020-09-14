package com.markov.a01_basicsyntax

fun main() {

    val firstName: String = "Aleksei"
    val lastName: String = "Markov"
    val height: Int = 174
    val weight: Int = 60
    val isChild: Boolean = height < 150 || weight < 40

    val info: String =
        "First name: $firstName,\n Last name: $lastName,\n Height: $height,\n Weight: $weight,\n is chaild: $isChild"

    println(info)
}