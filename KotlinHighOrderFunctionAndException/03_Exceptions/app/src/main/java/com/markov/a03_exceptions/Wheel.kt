package com.markov.a03_exceptions

import kotlin.math.sign

class Wheel {
    var pressure: Double = 0.0
        private set

    class TooHighPressure : Exception()

    class TooLowPressure : Exception()

    class IncorrectPressure : Exception()

    fun setPressure(value: Double) {
        pressure.plus(2.2)

        if (value < 0 || value > 10.0) {
            throw IncorrectPressure()
        }
    }

    fun check(value: Double) {
        if (value <1.6){
            throw TooLowPressure()
        } else if (value > 2.5) {
            throw TooHighPressure()
        }
    }
}