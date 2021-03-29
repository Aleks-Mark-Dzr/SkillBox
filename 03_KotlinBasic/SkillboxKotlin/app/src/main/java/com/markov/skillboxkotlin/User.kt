package com.markov.skillboxkotlin

data class User (
    val name: String,
    val lastName: String
) {
    var innerState: String = ""
}