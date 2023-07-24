package learn.atomic.objects

fun main() {
    println("started")

    val list = listFactory(1, 2, 3)
    println("list: $list")

    println("completed")
}

fun listFactory(vararg elements: Int): List<Int> {
    println("elements class: ${elements.javaClass}")

    val typedArray = elements.toTypedArray()
    println("typed array type: ${typedArray.javaClass}")

    return listOf(*typedArray)
}