package com.markov.a03_exceptions

import kotlin.math.sign

class Wheel {
    var pressure: Double= 0.0
        private set

    var negativePressure: Double = 0.0
    var tooMuchPressure: Double = 10.0

    class TooHighPressure : Exception()

    class TooLowPressure : Exception()

    class IncorrectPressure : Exception()

    fun setPressure(value: Double) {

        if (value < negativePressure || value > tooMuchPressure) {
            throw IncorrectPressure()
        }

        checkPessure(value)

        this.pressure = value
    }

    fun checkPessure(value: Double) {
        if (value < 1.6) {
            throw TooLowPressure()
        }
        if (value > 2.5) {
            throw TooHighPressure()
        }
    }
}