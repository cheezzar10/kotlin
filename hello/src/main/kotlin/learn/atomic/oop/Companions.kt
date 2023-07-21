package learn.atomic.oop

class Kind {
    init {
        println("creating new kind")
    }

    companion object {
        fun createKind() = Kind()
    }
}

fun main() {
    val kind = Kind.createKind()
    println("kind: $kind")
}