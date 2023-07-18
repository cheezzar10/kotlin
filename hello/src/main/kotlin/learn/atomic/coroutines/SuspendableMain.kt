package learn.atomic.coroutines

import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

val executor = Executors.newSingleThreadScheduledExecutor { runnable ->
    val newThread = Thread(runnable, "coroutine-scheduler")
    newThread.isDaemon = true

    newThread
}

fun log(message: String) {
    val currentThread = Thread.currentThread()
    println("[${currentThread.name}] - $message")
}

suspend fun main() {
    log("started")

    suspendCoroutine { continuation ->
        log("before suspension")

        // resuming execution after specified interval
        executor.schedule({ continuation.resume(Unit) }, 2, TimeUnit.SECONDS)
    }

    // object in kotlin creates both class and class instance
    val unit: Unit = Unit
    log(unit.toString())

    log("completed")
}