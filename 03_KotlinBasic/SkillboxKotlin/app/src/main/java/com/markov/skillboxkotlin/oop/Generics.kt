package com.markov.skillboxkotlin.oop

fun main() {
    val genericObject = GenericClass<Double>(0.0)

    val genericObject2 = GenericClass<Double>(0.0)
    val genericObject3 = GenericClass<Float>(0f)
    val genericObject4 = GenericClass<Float>(0f)

    println(sumGeneric(genericObject, genericObject2))
    println(sumGeneric(genericObject3, genericObject4))

    updateContrVariant(ContrVariantClass<Any>(234))
}

class GenericClass<out T : Number>(defaultValue: T) {
    private var item: T = defaultValue

    fun getItem(): T{
        return item
    }
}

class ContrVariantClass<in T>(defaultValue: T){
    private var item: T = defaultValue

    fun setItem (newItem: T) {
        item = newItem
    }
}

fun updateContrVariant(input: ContrVariantClass<Number>){
    input.setItem(2.2)
}

fun sumGeneric(a: GenericClass<Number>, b: GenericClass<Number>): Int {
    return a.getItem().toInt() + b.getItem().toInt()
}

fun <T> printGenegicObject(item: T) {
    println(item.toString())
}