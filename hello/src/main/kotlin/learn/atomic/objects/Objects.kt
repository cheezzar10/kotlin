package learn.atomic.objects

class Car(var name: String, var speed: Int = 0) {
    fun greet(greetings: Array<String>): String {
        return greetings[0]
    }

    override fun toString(): String {
        return "Car(name='$name', speed=$speed)"
    }
}

fun main() {
    println("started")

    val range = IntRange(0, 10)
    println("range: $range")

    val sum = range.sum()
    println("sum: $sum")

    // how many constructors kotlin class has by default
    val car = Car("Opel Astra")
    println("car: $car")

    println("car name: ${car.name}")

    // how to create an array in kotlin ( use arrayOf function )
    val greetings = arrayOf("Privet")

    // kotlin Array class compiled to plain java array
    println("array class: ${greetings.javaClass}")
    println("greetings: $greetings")

    val greeting = car.greet(greetings)
    println("greeting: $greeting")

    // how to check that two references point to the same object

    // annotations in kotlin ( see Kotlin in Action 10.1.4 )

    // how to define 'static' functions in kotlin
    // how to define package level utility functions in kotlin

    // kotlin infix functions

    println("completed")
}