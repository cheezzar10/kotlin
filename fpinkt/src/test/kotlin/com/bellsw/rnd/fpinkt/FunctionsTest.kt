package com.bellsw.rnd.fpinkt

import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions

class FunctionsTest {
    @Test
    fun testCurry() {
        val plus: (Int, Int) -> Int  = { a, b -> a + b }
        Assertions.assertEquals(5, plus(2, 3))

        Assertions.assertEquals(5, Functions.curry(plus)(2)(3))
    }

    @Test
    fun testUncurry() {
        val plus: (Int) -> (Int) -> Int = { a: Int -> { b: Int -> a + b } }

        Assertions.assertEquals(7, plus(3)(4))
        Assertions.assertEquals(7, Functions.uncurry(plus)(3, 4))
    }
}