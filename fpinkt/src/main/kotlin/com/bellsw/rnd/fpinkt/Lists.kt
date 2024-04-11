package com.bellsw.rnd.fpinkt

val <T> List<T>.head: T
	get() = this[0]

val <T> List<T>.tail: List<T>
	get() = this.subList(1, this.size)

object Lists {
    fun <A : Comparable<A>> notGreater(a: A, b: A) = a <= b

    fun <A : Comparable<A>> isSorted(aa: List<A>, order: (A, A) -> Boolean): Boolean {
        tailrec fun go(hd: A, tl: List<A>): Boolean =
            when {
                tl.isEmpty() -> true
                else ->
                    if (!order(hd, tl.head)) false
                    else go(tl.head, tl.tail)
            }

        return when {
            aa.isEmpty() -> true
            aa.size == 1 -> true
            else -> go(aa.head, aa.tail)
        }
    }
}