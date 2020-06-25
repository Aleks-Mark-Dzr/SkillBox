package com.markov.skillboxkotlin

import kotlin.math.abs

fun main() {

    println("Пожалуйста, введите число")
    val number = readLine()?.toIntOrNull() ?: return

    println("Пожалуйста, введите $number чисел")

    val result = readEveryNumbers(number)
    println("Финальный результат $result")

    printPositive(result)
    evenNumbers(result)
    uniqueNumber(result)
    val sum = sum(result)
    val map = createMap(result, sum)
    pairMap(map, sum)
}

fun readEveryNumbers(n: Int): List<Int> {
    val list = mutableListOf<Int>()
    while (list.size < n) {
        readLine()?.toIntOrNull()?.let { list.add(it) }
        println("Результат: $list")
    }
    return list
}

fun printPositive(list: List<Int>) {
    var positive = 0
    list.forEach {
        if (it > 0) {
            positive++
        }
    }
    println("Количество положительных: $positive")
}

fun evenNumbers(result: List<Int>) {
    val evenNumbers = result.filter { it % 2 == 0 }
    println("Четные числа: $evenNumbers")
}

fun uniqueNumber(result: List<Int>) {
    val uniqueNumber = result.toSet()
    println("Уникальных чисел: $uniqueNumber")
}

fun sum(result: List<Int>): Int {
    val sumNumbers = result.sum()
    println("Сумма чисел равна $sumNumbers")
    return sumNumbers
}

tailrec fun gcd(sum: Int, number: Int): Int {
    return if (number == 0) {
        sum
    } else gcd(number, sum % number)
}

fun createMap(result: List<Int>, sum: Int): Map<Int, Int> {
    val map = mutableMapOf<Int, Int>()
    result.forEach { n ->
        val gcd = gcd(abs(sum), abs(n))
        map.put(n, gcd)
        println(map)
    }
    return map
}

fun pairMap(m: Map<Int, Int>, sum: Int) {
    for (pair in m) {
        println("Число ${pair.key}, Сумма ${sum}, НОД ${pair.value}")
    }
}