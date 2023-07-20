package learn.atomic.coroutines

import kotlin.coroutines.suspendCoroutine

suspend fun main() {
    log("started")

    suspendCoroutine<Unit> { continuation ->
        log("suspending")
        Coroutines.resumeCoroutineAfterDelay(continuation, 1000)
    }

    log("completed")
}