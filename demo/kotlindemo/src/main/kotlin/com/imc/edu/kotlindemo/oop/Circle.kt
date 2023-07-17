package com.imc.edu.kotlindemo.oop

import kotlin.math.pow

class Point constructor(val x: Double, val y: Double)

class Circle(val center: Point, val radius: Double) {
    // wanna be c++
    constructor(center: Point) : this(center, 0.0)

    fun area(): Double = Math.PI * radius.pow(2.0)
}

fun main(args: Array<String>) {

}