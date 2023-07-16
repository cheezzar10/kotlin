package learn.atomic.usability

fun main() {
    println("started")

    val names = listOf("Liubov", "Anastasiia", "Alena", "Andrey")

    // here we just calling names.iterator() and iterating as usual
    for (name in names) {
        println(name)
    }

    println("completed")
}