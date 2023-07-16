package learn.atomic.functional

fun main() {
    // creating sequence from a list
    val names = listOf("Liubov", "Anastasiia", "Alena")

    val namesSeq = names.asSequence()
    println("names sequence: $namesSeq")
}