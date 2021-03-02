package com.markov.generics

import kotlin.random.Random

fun main() {

    getEvenNumbers(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 2.0, 2.3, 8.0, 6.0f))
}

fun <T : Number> getEvenNumbers(numbers: List<T>): List<T> {
    val newNumbersDouble = numbers.filter { it.toDouble() % 2.0 == 0.0 }
    println("Четные числа $newNumbersDouble")
    return newNumbersDouble
}

fun getResult(): Result<Int, String> {
    if(Random.nextBoolean()) {
        return Result.Success(1)
    } else {
        return Result.Error("Error")
    }
}