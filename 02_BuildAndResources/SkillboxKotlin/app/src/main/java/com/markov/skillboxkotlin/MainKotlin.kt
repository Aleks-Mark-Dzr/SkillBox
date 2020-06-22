package com.markov.skillboxkotlin

fun main() {
    val shortVal: Short =123
    val intVal =1366561246
    val longVal = 746812648L

    val floatVal = 872682763876.2382376428464f
    val doubleVal = 3423.63623456234

   val booleanVal:Boolean = true
   val booleanVal2:Boolean = false

    val booleanVal3 = booleanVal || booleanVal2
    val booleanVal4 = booleanVal.not() && booleanVal2

    val isEqual = intVal == 5
    val isGreater = intVal >= 5

    val charVal: Char = '2'
    val stringVal = "string"
    val multistringVal = """
        jhfdjfg
        jjg
        weuff
    """.trimIndent()


    val name = "Ivan"
    val lastName = "Ivanov"
    val isMale = false

    val humanReadableName = "My name is ${name} and lastname ${lastName}"
    val humanReadableExpanded = "${if (isMale) "His" else "Her"} name is $name and lastname $lastName"

    print(humanReadableExpanded)

    7234574f.toDouble()
    1324.toString()
    "123".toInt()
}