package learn.atomic.oop

interface Movable {
    // interface can define properties
    fun move()
}

class Car : Movable {
    override fun move() {
        println("moving car")
    }
}

// SAM interface
fun interface NoArg<R> {
    fun f(): R

    // single method only
    // fun g()
}

// implementing SAM interfaces
class NoArgImpl : NoArg<Int> {
    override fun f() = 1
}

fun interface XtoY<A, B> {
    fun f(a: A): B
}

val x2y = XtoY { x: Int -> x * x  }

fun main() {
    println("started")

    val car = Car()
    println("car: $car")

    car.move()

    val noArgImpl = NoArgImpl()

    val result = noArgImpl.f()
    println("result: $result")

    val noArgSam = NoArg { "cafebabe" }

    val samResult = noArgSam.f()
    println("sam result: $samResult")

    val squared = x2y.f(4)
    println("squared: $squared")

    // val localX2Y: XtoY<Int, Int> = { x: Int -> x * x * x }

    fun <A, B> apply(x: A, f: XtoY<A, B>): B  = f.f(x)
    val r = apply(5) { x: Int ->
        x + x
    }
    println("r = $r")

    val x = {
        val y = 1
        y + 1
    }
    println("x = $x")
}