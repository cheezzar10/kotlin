package com.bellsw.rnd.fpinkt

object Functions {
    fun <A, B, C> curry(f: (A, B) -> C): (A) -> (B) -> C =
        { a: A -> { b: B -> f(a, b) } }

    fun <A, B, C> uncurry(fnc: (A) -> (B) -> C): (A, B) -> C =
        { a: A, b: B -> fnc(a)(b) }
}