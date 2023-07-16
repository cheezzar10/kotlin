package learn.atomic.usability

fun main() {
    println("started")

    var name: String = "Doug Lea"
    println("name: $name")

    // String type is non-nullable, so we can't put null there
    // name = null

    var uid = generateUid()
    println("uid: $uid")

    if (uid != null) {
        val uidLength = uid.length
        println("uid length: $uidLength")
    }

    // the same

    // how to create generic array list in kotlin

    println("completed")
}

fun generateUid(): String? {
    val now = System.currentTimeMillis()
    if (now % 2 == 0L) {
        return null
    } else {
        return now.toString()
    }

}
