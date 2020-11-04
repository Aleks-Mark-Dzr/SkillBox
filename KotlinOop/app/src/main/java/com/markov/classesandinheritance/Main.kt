package com.markov.classesandinheritance

import kotlin.random.Random

fun main() {
    
    var zoo = Zoo()
    zoo.animalList =
        mutableListOf(
            Dog (100, 5),
            Fish (100, 3),
            Bird (120, 4),
            Bird (120, 3),
            Bird (125, 5),
            Bird (110, 3),
            Bird (124, 4),
            Fish (115, 4),
            Fish (117, 7),
            Dog (127, 8),
            object : Animal(130, 100, "Miha") {},
            object : Animal(135, 80, "Kisa") {}
        )

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