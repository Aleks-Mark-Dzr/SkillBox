package com.markov.skillboxkotlin.oop

data class User(
    val name: String,
    val lastName: String,
    val age: Int = 0
) {
    fun getFullnameLegth() = "$name$lastName".length
}