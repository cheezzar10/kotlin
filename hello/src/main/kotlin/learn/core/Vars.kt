package learn.core

fun main() {
    var productId: String = "1"
    val clientId: String = "foo"

    productId = "2"
    // clientId = "bar"

    val expireIn: Long = 1

    val rawString = """some
        |token
        |value""".trimMargin()

    println("token value: " + rawString)
}