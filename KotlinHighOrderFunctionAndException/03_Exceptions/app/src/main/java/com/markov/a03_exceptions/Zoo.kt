package com.markov.a03_exceptions

class Zoo {
    var animalList = mutableListOf<Animal>()

    public fun removeOldAnimal() {
        animalList.filter {
            !it.isTooOld
        }
    }
}