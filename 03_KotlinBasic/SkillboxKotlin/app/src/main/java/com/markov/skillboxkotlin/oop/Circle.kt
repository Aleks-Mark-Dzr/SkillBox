package com.markov.skillboxkotlin.oop

import com.markov.skillboxkotlin.oop.Shape

class Circle(
    raduis: Int
) : Shape {

    override val name: String = "Circle"

    override fun calculateArea(): Double {
        return Math.PI*raduis*raduis
    }
    var raduis: Int by PrintAreaOnChangeDelegate(raduis)

}
