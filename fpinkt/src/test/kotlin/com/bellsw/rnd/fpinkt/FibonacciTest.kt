package com.bellsw.rnd.fpinkt

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class FibonacciTest {
    @Test
    fun test() {
        val fib = Fibonacci()
        Assertions.assertEquals(34, fib.get(9))
    }
}