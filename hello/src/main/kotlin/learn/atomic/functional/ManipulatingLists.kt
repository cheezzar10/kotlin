package learn.atomic.functional

fun main() {
    // zipping lists
    val firstNames = listOf("Liubov", "Anastasiia", "Alena")
    val lastNames = listOf("Smirnova", "Smirnova", "Smirnova")

    // generating list of pairs
    val fullNames = firstNames.zip(lastNames)
    println("full names: $fullNames")

    val fullName = fullNames[0]
    println("full name class: ${fullName.javaClass}")

    val pair = Pair("Billy", "Bones")

    val zipped = myzip(firstNames, lastNames) { left, right ->
        left to right
    }
    println("zipped: $zipped")
}

inline fun <T, V, R> myzip(left: Iterable<T>, right: Iterable<V>, transform: (T, V) -> R): List<R> {
    val leftIterator = left.iterator()
    val rightIterator = right.iterator()

    val result = mutableListOf<R>()
    while (leftIterator.hasNext() && rightIterator.hasNext()) {
        val leftElement = leftIterator.next()
        val rightElement = rightIterator.next()

        result += transform(leftElement, rightElement)
    }

    return result
}