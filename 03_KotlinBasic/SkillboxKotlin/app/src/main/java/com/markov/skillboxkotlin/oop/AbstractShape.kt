package com.markov.skillboxkotlin.oop

abstract class AbstractShape (
    private var x: Int,
    private var y: Int
): Shape {
    fun moveToPosition(x: Int, y: Int){
        this.x = x
        this.y = y
    }

    fun printPosition(){
        println("Shape with position (x = $x, y = $y)")
    }
}