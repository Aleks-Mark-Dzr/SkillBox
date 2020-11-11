package com.markov.basemethodsandpropertydelegates

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ReadOnlyPropertyDelegate: ReadOnlyProperty <Any?, HashSet<Animal>>{
    var currentValue = hashSetOf<Animal>()
    override fun getValue(thisRef: Any?, property: KProperty<*>): HashSet<Animal> {

        println(currentValue)
        return currentValue
    }

}