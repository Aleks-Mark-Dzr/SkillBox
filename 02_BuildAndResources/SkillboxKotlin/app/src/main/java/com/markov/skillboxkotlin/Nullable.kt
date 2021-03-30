package com.markov.skillboxkotlin

fun main() {
//  readLine()?.toIntOrNull()
//      ?.let { it: Int
//          println("Вы ввели $it")
//      }
//      ?: println("Вы ввели не число")
    printLength(null)
}

fun printLength(string: String?) {
    string ?: return
    print("Длина строки = ${string!!.length}")
}