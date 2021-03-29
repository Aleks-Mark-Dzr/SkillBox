package com.markov.skillboxkotlin

import com.markov.skillboxkotlin.oop.*

fun main() {

    val shape = Rectangle(1, y = 1, width = 2, height = 2)

    val largeRectangle = Rectangle(1, 1, 20, 30)

    val set: MutableSet<Rectangle> = hashSetOf(
        largeRectangle,
        shape
    )

    set.size
    println(set)
}