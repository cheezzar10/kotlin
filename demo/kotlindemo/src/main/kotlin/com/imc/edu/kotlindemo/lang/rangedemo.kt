package com.imc.edu.kotlindemo.lang

fun main(args: Array<String>) {
    for (i in 0 until 1) {
        println("$i")
    }

    val i: Int? = 0
    println(i?.javaClass)
    println(i!!::class)
}