package learn.atomic.functional

fun main() {
    // creating sequence from a list
    val names = listOf("Liubov", "Anastasiia", "Alena")

    val namesSeq = names.asSequence()
    println("names sequence: $namesSeq")

    val seq: Sequence<Int> = sequence {
        yield(1)
    }

    val seqIter = seq.iterator()
    val number = seqIter.next()
    println("number: $number")
}

fun shadowed(i: Int) {
    val i: String = "" + i
}