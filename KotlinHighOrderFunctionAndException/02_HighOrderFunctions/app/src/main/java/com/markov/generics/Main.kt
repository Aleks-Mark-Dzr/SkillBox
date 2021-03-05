package com.markov.generics

import kotlin.random.Random

fun main() {

    getEvenNumbers(listOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 2.0, 2.3, 8.0, 6.0f))
    val name = Queue<Int>()

    name.enqueue(1)
    name.enqueue(2)
    name.enqueue(3)
    name.enqueue(4)

    name.filter { it % 2.0 == 0.0 }
    name.filter (:: filetrFunction)
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

fun filetrFunction (a :Int): Boolean {
    return a != 10
}