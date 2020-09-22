package com.markov.a04_collections

fun main() {

    println("Пожалуйста, введите число")
    val number = readLine()?.toIntOrNull() ?: return

    println("Пожалуйста, введите $number номеров телефонов пользователей")
    val phoneNumbers = readPhoneNumbers(number)
    printRightNumbers(phoneNumbers)
    countUniqueNumbers(phoneNumbers)
    sumSize(phoneNumbers)
    createMutableMap(phoneNumbers)
}

fun readPhoneNumbers(n: Int): List<String> {

    val mutableList = mutableListOf<String>()
    for (i in 1..n) {
        readLine().let {mutableList.add(it?: "") }
    }

    println("Список телефонов $mutableList")
    return mutableList
}

fun printRightNumbers(mutableList: List<String>) {
    println("Номера, начинающиеся с +7 ${mutableList.filter { it -> it.startsWith("+7") }}")
}

fun countUniqueNumbers(mutableList: List<String>) {
    val uniqueNumbers = mutableList.toSet().size
    println("Количество уникальных номеров $uniqueNumbers")
}

fun sumSize(mutableList: List<String>){
    val sum = mutableList.sumBy { it -> it.length }
    println("Сумма длин всех номеров телефонов $sum")
}

fun createMutableMap(mutableList: List<String>){
    val mutableMap = mutableMapOf<String, String>()
    for (i in 0..mutableList.size-1) {
        val phone = mutableList.get(i)
        println("Введите имя контакта $phone")
        val name = readLine()?:""
        mutableMap.put(phone, name)
        println(mutableMap)
    }
    mutableMap.forEach{println("Человек: ${it.value}. Номер телефона: ${it.key}")}
}