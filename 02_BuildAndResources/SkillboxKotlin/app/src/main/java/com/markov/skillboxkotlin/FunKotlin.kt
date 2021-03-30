package com.markov.skillboxkotlin

import kotlin.random.Random

fun main() {
    //text comment

    hasChildAccess(height = /*110*/ 120, weight = 50, age = 20)
    val any = functionReturnsAny()
    functionWihtAnyParam( "string")
    functionWihtAnyParam( "v")
    functionWihtAnyParam( 3)

}

fun multiply(a: Int = 100, b: Int): Int = a * b

fun hasChildAccess(height: Int, weight: Int, age: Int): Boolean{
    return height >150 && weight >30 && age >10
}

fun functionReturnsAny(): Any{
    return if(Random.nextBoolean()) {
        62541264
    } else {
        "jsdhgsjhfg"
    }
}

fun functionWihtAnyParam(param: Any): Unit {
return
}