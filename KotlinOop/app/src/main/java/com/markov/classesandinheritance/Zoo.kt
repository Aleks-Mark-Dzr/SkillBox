package com.markov.classesandinheritance

class Zoo {
    var animalList = mutableListOf<Animal>()

    public fun removeOldAnimal() {
        animalList.filter {
            !it.isTooOld
        }
    }
}