package learn.atomic.functional

import learn.atomic.objects.Car

data class IntWrapper(val value: Int)

fun main() {
    val indexes = listOf(1, 2, 3, 4)

    val mapped = indexes.map({ i: Int -> "[$i]" })
    println("mapped: $mapped")

    // method reference
    val methodRefMapped = indexes.map(Int::toString)
    println("ref mapped: $methodRefMapped")

    // constructor reference
    val wrapperMapped = indexes.map(::IntWrapper)
    println("wrapper mapped: $wrapperMapped")

    // references to top-level functions are also possible

    // the same, but short form
    val shortMapped = indexes.map { index ->
        // several statements, ending with an expression
        println("mapping")
        "[$index]"
    }

    val kotlinClass = Car::class
    println("kotlin class: $kotlinClass")

    // create collection of closures
    // what's the lambda signature ???
    val functions = mutableListOf<() -> String>()
    var index = 0
    while (index < 10) {
        functions.add({ "captured var: $index" })
        index++
    }

    for (f in functions) {
        println(f())
    }

    val newList = List(10, { it })
    println("new list: $newList")

    // inline functions and inline lambdas
}