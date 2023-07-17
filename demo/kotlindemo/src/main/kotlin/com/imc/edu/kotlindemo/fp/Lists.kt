package com.imc.edu.kotlindemo.fp

class Bomb(val v: Int) {
    override fun equals(other: Any?): Boolean  {
        if (v == 1) throw IllegalStateException("kaboom")

        return when {
            this === other -> true
            other !is Bomb -> false
            else -> v == other.v
        }
    }

    override fun hashCode() = v
}

fun main(args: Array<String>) {
    val m = mapOf(Bomb(1) to 2, Bomb(1) to 1)
    println("completed")
}