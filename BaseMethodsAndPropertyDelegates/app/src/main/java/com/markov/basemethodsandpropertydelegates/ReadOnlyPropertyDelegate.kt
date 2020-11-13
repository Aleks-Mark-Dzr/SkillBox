package com.markov.basemethodsandpropertydelegates

import kotlin.properties.ReadOnlyProperty
import kotlin.reflect.KProperty

class ReadOnlyPropertyDelegate<T>(
    private var value: T
): ReadOnlyProperty <Person, T>{
    var currentValue = hashSetOf<Animal>()
    override fun getValue(thisRef: Person, property: KProperty<*>): T  {
        println(thisRef.name)
        println(value)
        return value
    }

}