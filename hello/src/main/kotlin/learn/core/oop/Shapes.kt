package learn.core.oop

class Point(_x: Double, _y: Double) {
    val x: Double = _x
    get() {
        println("getting x")
        return field
    }

    private val y: Double = _y

    override fun toString(): String {
        return "Point: { x: $x, y: $y }"
    }
}

fun main() {
    val p = Point(0.1, 0.2)

    println("p.x = " + p.x)

    println("$p")
}