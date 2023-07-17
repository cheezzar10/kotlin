package learn.atomic.oop

import java.lang.UnsupportedOperationException

interface Insect {
    fun walk(): String = "$name: walk"
    fun fly(): String = "$name: fly"
}

class HouseFly : Insect

class Flea : Insect {
    override fun fly() = throw UnsupportedOperationException("Flea cannot fly")
    fun crawl() = "Flea: crawl"
}

val Any.name get() = this::class.simpleName

fun Insect.basic(): String =
    walk() + " " + if (this is Flea) crawl() else fly()

fun main() {
    val insects = listOf(HouseFly(), Flea())

    val actions = insects.map { insect ->
        insect.basic()
    }.joinToString(prefix = "[ ", separator = ", ", postfix = " ]")

    println("$actions")
}