package learn.atomic.generics

import java.lang.StringBuilder

class SimpleArrayList<T>(private var capacity: Int = 10) {
    var elements: Array<Any?> = arrayOfNulls(capacity)
    var size: Int = 0

    fun add(element: T) {
        // TODO check current capacity
        elements[size] = element
        size++
    }

    override fun toString(): String {
        val buffer = StringBuilder()
        buffer.append("[")

        for (index in 0 until size) {
            buffer.append(elements[index])

            if (index < size - 1) {
                buffer.append(",")
            }
        }

        buffer.append("]")

        return buffer.toString()
    }
}

fun main() {
    val numbers = SimpleArrayList<Int>(capacity = 2)

    numbers.add(1)
    numbers.add(3)
    numbers.add(5)

    println("numbers: $numbers")
}