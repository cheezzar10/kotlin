package learn.atomic.objects

import java.lang.IllegalArgumentException

fun main() {
    println("started")

    val input = "some shit"
    val number = input.toIntOrNull()

    // what's the meaning of this warning ???
    if (number == null) {
        throw IllegalArgumentException("'$input' can't be parsed as int")
    }
    println("number: $number")

    // how to define our own list in kotlin

    println("completed")
}