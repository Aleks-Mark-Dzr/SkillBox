package com.markov.a03_exceptions

fun main() {

    val wheel = Wheel()
    try {
        wheel.setPressure(12.6)
        println("Correct Pressure = ${wheel.pressure}")
    } catch (e1: Wheel.TooHighPressure) {
        println("Too high pressure")
    } catch (e2: Wheel.TooLowPressure) {
        println("Too low pressure")
    } catch (e3: Wheel.IncorrectPressure) {
        println("Incorrect pressure")
    }
}
