package learn.atomic.objects

fun main() {
    println("started")

    // generating lists in kotlin
    val numbers = listOf(1, 2, 3, 4)
    println("number: $numbers")
    println("numbers class: ${numbers.javaClass}")

    val arrayList = ArrayList<Int>(10)
    println("array list class: ${arrayList.javaClass}")

    val mutableList = mutableListOf<Int>()
    mutableList += 1

    println("mutable list: $mutableList")
    println("mutable list class: ${mutableList.javaClass}")

    // operations with sets
    val numbersSet = setOf(1, 2, 2, 3, 4)
    println("numbers set: $numbersSet")
    // LinkedHashSet
    println("numbers set class: ${numbersSet.javaClass}")

    // operations with maps

    println("completed")
}