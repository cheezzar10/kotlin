package com.imc.edu.kotlindemo

import java.io.PrintWriter
import java.io.StringWriter

class TreeNode(
    val key: String,
    left: TreeNode? = null,
    right: TreeNode? = null,
    var parent: TreeNode? = null) {

    var left: TreeNode? = left
        set(value) {
            field = value
            if (value != null) {
                value.parent = this
            }
        }

    var right: TreeNode? = right
        set(value) {
            field = value
            if (value != null) {
                value.parent = this
            }
        }

    override fun toString(): String {
        return "node $key"
    }
}

class Tree {
    var root: TreeNode? = null

    fun rotateRight(node: TreeNode?) {
        // throw expression return type is Nothing and Nothing is the subtype of every other type
        val nodeParent = node?.parent ?: throw IllegalArgumentException("can't perform rotation")

        if (nodeParent.left != node) {
            throw IllegalArgumentException("can't perform right rotation on right subtree")
        }

        val nodeGrandParent = nodeParent.parent
        if (nodeGrandParent != null) {
            if (nodeGrandParent.left == nodeParent) {
                nodeGrandParent.left = node
            } else {
                nodeGrandParent.right = node
            }
        } else {
            root = node
        }

        nodeParent.left = node.right
        node.right = nodeParent
    }

    fun rotateRight2(node: TreeNode?) {
        // throw expression return type is Nothing and Nothing is the subtype of every other type
        val nodeParent = node?.parent ?: throw IllegalArgumentException("can't perform rotation")

        if (nodeParent.left != node) {
            throw IllegalArgumentException("can't perform right rotation on right subtree")
        }

        val nodeGrandParent = nodeParent.parent
        if (nodeGrandParent != null) {
            if (nodeGrandParent.left == nodeParent) {
                nodeGrandParent.left = rotateRightWithReturn(nodeParent)
            } else {
                nodeGrandParent.right = rotateRightWithReturn(nodeParent)
            }
        } else {
            root = rotateRightWithReturn(nodeParent)
        }
    }

    private fun rotateRightWithReturn(node: TreeNode?): TreeNode? {
        val tempNode = node?.left
        node?.left = tempNode?.right
        tempNode?.right = node
        return tempNode
    }

    fun printTree() {
        printNode(root, 0)
    }

    private fun printNode(node: TreeNode?, depth: Int) {
        if (node == null) return

        printNode(node.right, depth + 1)
        for (i in 0 until depth) {
            print("--")
        }

        print(node.key)
        println()

        printNode(node.left, depth + 1)
    }

    override fun toString(): String {
        val buffer = StringWriter()
        val writer = PrintWriter(buffer)
        nodeToString(root, 0, writer)

        return buffer.toString()
    }

    private fun nodeToString(node: TreeNode?, depth: Int, writer: PrintWriter) {
        if (node == null) return

        nodeToString(node.right, depth + 1, writer)
        for (i in 0 until depth) {
            writer.print("--")
        }

        writer.print(node.key)
        writer.println()

        nodeToString(node.left, depth + 1, writer)
    }
}

fun main(args: Array<String>) {
    val tree = Tree()

    val rootNode = TreeNode("Cabbage")
    tree.root = rootNode

    val leftChild = TreeNode(key = "Beer", parent = rootNode)
    rootNode.left = leftChild

    val rightChild = TreeNode(key = "Eggs", parent = rootNode)
    rootNode.right = rightChild

    val leftGrandChild = TreeNode(key = "Bacon", parent = leftChild)
    leftChild.left = leftGrandChild

    val rightGrandChild = TreeNode(key = "Butter", parent = leftChild)
    leftChild.right = rightGrandChild

    println("original tree:\n$tree")

    tree.rotateRight(leftChild)
    println("rotated tree:\n$tree")
}