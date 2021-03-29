package com.markov.skillboxkotlin.oop

class Rectangle(
    x: Int,
    y: Int,
    width: Int,
    height: Int
): AbstractShape(x, y), Comparable<Rectangle> {

    var width: Int by PrintAreaOnChangeDelegate(width)
    var height: Int by PrintAreaOnChangeDelegate(height)

    override val name: String = "Rectangle"

    override fun calculateArea(): Double = width * height.toDouble()

    override fun toString(): String {
        return "Rectangle(width=$width, height=$height)"
    }

    override fun compareTo(other: Rectangle): Int {
        TODO("Not yet implemented")
    }

    operator fun plus(other: Rectangle): Rectangle {
        return Rectangle(0,0,width + other.width, height + other.height)
    }

    operator fun unaryMinus(): Rectangle {
        return Rectangle(0,0, -width, -height)

    }


}