package com.markov.skillboxtraning

data class User(
        val name: String,
        val lastName: String,
        val age: Int = 0
) {
    fun getFullnameLegth() = "$name$lastName".length
}