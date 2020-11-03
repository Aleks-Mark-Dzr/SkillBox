package com.markov.classesandinheritance

import kotlin.random.Random

fun main() {

    var dog: Animal = Dog(100, 5)
    var fish = Fish(100, 1)
    var bird = Bird(100, 3)
    var bird2 = Bird(130, 6)
    var bird3 = Bird(120, 7)
    var bird4 = Bird(135, 6)
    var bird5 = Bird(125, 5)
    var fish2 = Fish(120, 5)
    var fish3 = Fish(130, 8)
    var dog2 = Dog(135, 7)
    var panda = object : Animal(130, 100, "Miha") {}
    var tiger = object : Animal(135, 80, "Kisa") {}

    var zoo = Zoo()
    zoo.animalList =
        mutableListOf(dog, fish, bird, bird2, bird3, bird4, bird5, fish2, fish3, dog2, panda, tiger)

    val N = 3

    for (i in 0..N) {
        for (a in 0..zoo.animalList.count()){
            val b = zoo.animalList[a]
            randomAction(b, zoo)
        }

        zoo.removeOldAnimal()
        val countAnimal = zoo.animalList.count()
        println("количество животных в зоопарке $countAnimal")

        if (zoo.animalList.count() == 0){
            println("все животные вымерли")
            break
        }
    }


//    while (true){
//
//        if(dog.isTooOld){
//            dog = dog.makeChild()
//        } else {
//            dog.eat()
//            dog.move()
//            dog.sleep()
//        }
//    }
}

fun randomAction(animal: Animal, zoo: Zoo) {
    if (animal is Soundable) {
        val number = Random.nextInt(4)
        when (number) {
            0 -> animal.sleep()
            1 -> animal.eat()
            2 -> animal.move()
            3 -> {
                val child = animal.makeChild()
                zoo.animalList.add(child)
            }
            4 -> animal.makeSound()
        }
    } else {
        val number = Random.nextInt(3)
        when (number) {
            0 -> animal.sleep()
            1 -> animal.eat()
            2 -> animal.move()
            3 -> {
                val child = animal.makeChild()
                zoo.animalList.add(child)
            }
        }
    }

}