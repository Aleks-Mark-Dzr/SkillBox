package com.markov.skillboxkotlin.oop

sealed class SealedColor (
    val hex: String
): Drawable {

    override fun draw() {
        println("draw sealed")
    }

}

object White: SealedColor("#fff")
object Black: SealedColor("#000") {
    override fun draw() {
        println("draw black")
    }
}

class CustomColor(hex: String) : SealedColor (hex)