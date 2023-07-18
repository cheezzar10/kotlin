package learn.atomic.advanced

class A {
    fun af() = 1
}

class B {
    fun bf() = 1
}

fun f2(f: A.(B) -> Int): Int = A().f(B())

fun plainLambdaBuildString(builder: (StringBuilder) -> Unit): String {
    val stringBuilder = StringBuilder()
    builder(stringBuilder)
    return stringBuilder.toString()
}

fun myBuildString(builder: StringBuilder.() -> Unit): String {
    val stringBuilder = StringBuilder()
    stringBuilder.builder()
    return stringBuilder.toString()
}

fun main() {
    // just plain lambda function
    val va: (String, Int) -> String = { str, n ->
        str.repeat(n) + ":" + str.repeat(n)
    }

    val resultVa = va("foo", 4)
    println(resultVa)

    // ok, lambda with receiver
    val vb: String.(Int) -> String = { n ->
        // repeat can be called w/o qualification with this.
        this.repeat(n) + "::" + repeat(n)
    }

    val resultVb = "bar".vb(2)
    println(resultVb)

    // passing lambda with receiver as a function argument
    f2 {
        b -> af() + b.bf()
    }

    val plainlyBuiltString = plainLambdaBuildString {
        it.append("some")
        it.append("shit")
    }
    println(plainlyBuiltString)

    val builtString = myBuildString {
        append("some ")
        append("another ")
        append("shit")
    }
    println(builtString)

    ("Andrey" to 42).run {
        val (name, age) = this

        println("name: $name, age: $age")
    }
}