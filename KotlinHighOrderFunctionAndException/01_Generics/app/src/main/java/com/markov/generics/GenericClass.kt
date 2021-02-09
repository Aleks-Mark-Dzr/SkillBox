package com.markov.generics

class GenericClass<T: Number> {

    fun filterList(list: List<T>): List<T> {
        val newListInt = list.filter { (it is Int || it is Long || it is Short) && it.toInt() % 2 == 0 }
        val newListDouble = list.filter { it.toDouble().minus(it.toInt()) == 0.0 && it is Double && it.toInt() % 2 == 0 }
        println("Целые числа $newListInt")
        println("Вещественные числа $newListDouble")
        return newListInt
    }
}