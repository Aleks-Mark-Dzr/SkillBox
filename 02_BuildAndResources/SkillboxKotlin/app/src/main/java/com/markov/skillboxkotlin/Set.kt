package com.markov.skillboxkotlin

fun main() {
    val immutableSet = setOf(1, 2, 3, 3, 2, 1, 4, 5, 6, 7)
    println(immutableSet)

    val unionSet = setOf(1, 2, 3).union(setOf(1, 4, 5))
    println(unionSet)

//    функция вычитания
    val substractSet = setOf(1, 2, 3).subtract(setOf(1, 2, 4))
    println(substractSet)

//    функция пересечение
    val intersectSet = setOf(1, 2, 4).intersect(setOf(4, 5 ,5))
    println(intersectSet)

//   сортированное множество
    val naturalOrderSet = sortedSetOf(1, 4, -1, 2, 5, 2)
    println(naturalOrderSet.descendingSet())

    mutableSetOf(1, 2, 3).add(34)

    val hashSet = hashSetOf(1, 2, 3)
    hashSet.add(1)
    hashSet.remove(1)

    hashSet.contains(1)
    println(1 in hashSet)
}