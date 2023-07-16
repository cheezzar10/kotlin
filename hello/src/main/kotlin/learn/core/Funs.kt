package learn.core

fun main() {
    val r = mulByTwo(3)
    println("result: $r")

    val exceptionMessage = "failed to open connection"
    val errorMessage = """product creation failed: "$exceptionMessage" """

    println(errorMessage)

    val maxInt = Int.MAX_VALUE
    println(maxInt)
}

fun mulByTwo(x: Int) = x * 2