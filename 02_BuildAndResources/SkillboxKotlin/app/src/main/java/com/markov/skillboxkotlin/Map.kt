package com.markov.skillboxkotlin

fun main() {
    val pair1 = Pair("key", "value")
    val pair2 = 1 to 2

    println("first = ${pair1.first}, second = ${pair1.second}")
    println(pair2)

//    создадим Map (тлф справочник)
    val map = mapOf(
        "Number1" to "+79991111111",
        "Number1" to "+79981111111",
        "Number2" to "+79991111112",
        "Number3" to "+79991111113"
    )

    println(map["Number1"])
    println(map["Number4"])

//    создание изменяемого отображения (Map)
    val mutableMap = map.toMutableMap()
    val mutableMap2 = mutableMapOf("1" to "2")
    mutableMap["Name1"] = "1236546"
    mutableMap["Name"] = "12365"
    mutableMap.put("key", "value")
    mutableMap.remove("key")

    mutableMap.toMap()

    val sortedMap = sortedMapOf(
        "2" to "22",
        "3" to "33",
        "4" to "44",
        "1" to "11"
    )

    val hashMap = hashMapOf(
        "2" to "22",
        "3" to "33",
        "4" to "44",
        "1" to "11"
    )

    println(sortedMap)

    println(hashMap.keys)
    println(hashMap.values)

    for (key in hashMap.keys) {
        println("key = $key, value = ${hashMap[key]}")
    }

    hashMap.forEach {(key, value) ->
        key
        value
    }

}