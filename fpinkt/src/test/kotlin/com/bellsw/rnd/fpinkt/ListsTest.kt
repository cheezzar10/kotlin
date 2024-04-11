package com.bellsw.rnd.fpinkt

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

class ListsTest {
    private fun <T : Comparable<T>> isSorted(list: List<T>) = Lists.isSorted(list, Lists::notGreater)

    @Test
    fun testEmptyListIsSorted() {
        val emptyList = emptyList<Int>() 
        Assertions.assertTrue(isSorted(emptyList))
    }
    
    @Test
    fun testSingleElementListIsSorted() {
        val singleList = listOf(1)
        Assertions.assertTrue(isSorted(singleList))
    }

    @Test
    fun testSortedListIsSorted() {
        val list = listOf(1, 5, 3, 7, 2)
        Assertions.assertTrue(isSorted(list.sorted()))
    }
}