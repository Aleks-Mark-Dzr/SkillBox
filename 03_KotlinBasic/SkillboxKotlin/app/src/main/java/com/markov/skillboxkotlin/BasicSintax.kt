package com.markov.skillboxkotlin

import kotlin.math.abs

fun main() {

    var number: Int? = 0
    var countPositiveNumbers: Int = 0

    fun readEvenNumbers(n: Int): List<Int> {

        val list = mutableListOf<Int>()

        while (list.size < n) {
            readLine()?.toIntOrNull()?.let { list.add(it) }

            println("Результат: $list")
        }
        return list
    }

    fun printPositiveNumbers(list: List<Int>) {

        var numberP: Int = 0
        for (numberP in list) {
            if (numberP > 0) countPositiveNumbers++
        }
        println("Положительных чисел $countPositiveNumbers")
    }

    tailrec fun greatestCommonDivisor(sum: Int, number: Int): Int {
        if (sum == 0) return number
        if (number == 0) return sum
        if (sum == number) return number
        if (sum == 1) return 1
        if (number == 1) return 1
        if ((sum % 2 == 0) && (number % 2 == 0)) {
            return 2 * greatestCommonDivisor(sum / 2, number / 2)
        }
        if ((sum % 2 == 0) && (number % 2 == 1)) {
            return greatestCommonDivisor(sum / 2, number)
        }
        if ((sum % 2 == 1) && (number % 2 == 0)) {
            return greatestCommonDivisor(sum, number / 2)
        }
        if (number > sum) {
            return greatestCommonDivisor((number - sum) / 2, sum)
        } else {
            return greatestCommonDivisor((sum - number) / 2, number)
        }

    }

    println("Пожалуйста, введите число")
    readLine()?.toIntOrNull()
        ?.let { n ->
            number = n

            println("Пожалуйста, введите $number чисел")

            val result = readEvenNumbers(n)
            println("Финальный результат $result")

            printPositiveNumbers(result)

            val evenNumbers = result.filter { it % 2 == 0 }
            println("Четные числа: $evenNumbers")

            val uniqueNumber = result.toSet()
            println("Уникальных чисел: $uniqueNumber")

            val sumNumbers = result.sum()
            println("Сумма чисел равна $sumNumbers")

            val map = mutableMapOf<Int, Int>()

            for (number in result) {
                val gCD = greatestCommonDivisor(sumNumbers, abs(number))
                map.put(number, gCD)
                println("Наибольший общий делитель для $sumNumbers и $number: $gCD")
            }

            for (pair in map) {
                println("Число ${pair.key}, Сумма ${sumNumbers}, НОД ${pair.value}")
            }
        }

}

