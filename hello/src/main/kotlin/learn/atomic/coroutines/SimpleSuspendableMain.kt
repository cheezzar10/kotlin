package learn.atomic.coroutines

import kotlin.coroutines.suspendCoroutine

data class Product(val name: String, val price: Long)

suspend fun main() {
    log("started")

    val product = Product("bread", 100)
    println(product)

    suspendCoroutine<Unit> { continuation ->
        Coroutines.resumeCoroutineAfterDelay(continuation, 1000)
    }

    log("completed")
}