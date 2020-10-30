package com.markov.classesandinheritance

fun main() {

    val animal: Animal = Animal(100, 5, 15, "Keks")

    while (!animal.isTooOld){
        animal.eat()
        animal.move()
        animal.sleep()
    }
    animal.makeChild()
}