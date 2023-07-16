package learn.core

fun main() {
    val name = "kotlin"

    val result = 't' in name
    println("result: $result")

    val anotherResult = 'z' !in name
    println("another result: $anotherResult")

    val stringRange = "aa".."az"
    val checkResult = "ab" in stringRange
    println("check result: $checkResult")

    // seems like ClosedRange<String> can not be used as iteration source
    // for (s in stringRange) { println("'$s' ") }

    val unit: Unit = unitFun2()
}

fun unitFun(): Unit {
    var r = println()
    return r
}

fun unitFun2() = Unit