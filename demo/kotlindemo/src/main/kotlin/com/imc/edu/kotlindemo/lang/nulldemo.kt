package com.imc.edu.kotlindemo.lang

class Node(val parent: Node?)

fun main(args: Array<String>) {
    val node: Node? = Node(null)

    if (node?.parent == null) {
        println("null node")
    }

    println("completed")
}