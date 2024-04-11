
package com.bellsw.rnd.fpinkt

// 0, 1, 1, 2, 3, 5, 8, 13, 21, 34

class Fibonacci {
    fun get(n: Int): Int {
        tailrec fun loop(np: Int, nc: Int, cn: Int): Int = 
            if (cn == n) np + nc else loop(nc, np + nc, cn + 1) 

        return if (n <= 1) n else loop(0, 1, 2)
    }
}