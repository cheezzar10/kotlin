package learn.atomic.oop

// empty parameters primary constructor is needed
// after creating aux constructor
class DelayedJob() {
    private var taskId: Int? = null

    private var nodeName: String = ""

    // aux constructor
    constructor(taskId: Int) : this() {
        this.taskId = taskId
    }
}

fun main() {
    val delayedJob = DelayedJob(1)
    println(delayedJob.name)
}