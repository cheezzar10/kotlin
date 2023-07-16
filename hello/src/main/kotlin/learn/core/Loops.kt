package learn.core

fun main() {
    for (i in 0..3) {
        println(i)
    }

    val range: IntRange = 0..10
    val anotherRange: IntRange = 0 until 10

    println("anotherRange: ${anotherRange.javaClass}")

    for (e in anotherRange) {
        print("$e ")
    }

    println()

    val reverseRange = 10 downTo 0
    for (e in reverseRange) {
        print("$e ")
    }

    println()

    repeat(3) {
        print("hi ")
    }
}