package com.markov.skillboxkotlin.oop

import kotlin.properties.ReadWriteProperty
import kotlin.reflect.KProperty

fun main() {

    val car = Car(4,4,200)
    car.openDoor()
    car.closeDoor()
    car.accelerate(20)
}

class PrintAreaOnChangeDelegate<T>(
    private var value: T
): ReadWriteProperty<Shape, T> {
    override fun getValue(thisRef: Shape, property: KProperty<*>): T = value

    override fun setValue(thisRef: Shape, property: KProperty<*>, value: T) {
        println("before change property ${property.name} = ${thisRef.calculateArea()}")
        this.value = value
        println("after change property ${property.name} = ${thisRef.calculateArea()}")
    }
}