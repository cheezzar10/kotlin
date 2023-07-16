package learn.atomic.usability

import learn.atomic.objects.Car

fun Car.accelerate(delta: Int) {
    println("increasing speed on $delta km/h")
    this.speed += delta
}

fun Car.decelerate(delta: Int) {
    println("decreasing car speed in $delta km/h")
    this.speed -= delta
}

fun main() {
    println("started")

    val x = "key" to "value"
    println("x: $x")
    println("x class: ${x.javaClass}")

    // add extension method to Car
    val car = Car("Skoda Octavia")
    println("$car standing still")

    car.accelerate(20)
    println("$car is going")

    car.decelerate(10)
    println("$car is slowing down")

    println("completed")
}