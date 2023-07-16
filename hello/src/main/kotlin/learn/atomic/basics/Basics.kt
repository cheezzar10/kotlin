package learn.atomic.basics

// the simplest possible kotlin program
fun main() {
    println("started")

    // TODO define some variables
    var index = 0
    index++

    println("index: $index")
    println("index class: ${index.javaClass}")

    val weight = 82
    // weight += 1

    println("weight: $weight")

    val flag = true
    println("flag: $flag")

    val sum = plus(1, 2)
    println("sum: $sum")

    val unitResult = myPrintLn("some message")
    println("unit result: $unitResult")

    conditionalExpressions(weight)

    // casting weight to Double explicitly
    val bmi = bmi(weight.toDouble(), 1.82)
    println("bmi: $bmi")

    val explicitUnit = explicitUnit()
    println("explicit unit: $explicitUnit")

    println("completed")
}

fun plus(left: Int, right: Int) = left + right

fun myPrintLn(message: String): Unit {
    println(message)
}

fun conditionalExpressions(weight: Int): Unit {
    // if expressions
    val message = if (weight > 70) "fat" else "slim"
    println("message: $message")
}

fun bmi(weight: Double, height: Double): Double {
    return weight / (height * height)
}

fun explicitUnit(): Unit {
    return Unit
}