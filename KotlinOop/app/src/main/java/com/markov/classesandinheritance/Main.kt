package com.markov.classesandinheritance

fun main() {

    var dog: Animal = Dog (100, 5)
    val fish = Fish (100, 1)
    val bird = Bird (100, 3)

    while (true){

        if(dog.isTooOld){
            dog = dog.makeChild()
        } else {
            dog.eat()
            dog.move()
            dog.sleep()
        }
    }
}