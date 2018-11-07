package huffman.code.lib.tree

import java.lang.IllegalStateException

class NodeWalker(private val node: Node) {

    private var walkedNode: Node = node

    fun walk(code: Char): Node {
        if (code == '0') walkToLeft()

        if (code == '1') walkToRight()

        if (walkedNode.isLeaf()) {
            val leaf = walkedNode

            reset()

            return leaf
        }

        return walkedNode
    }

    private fun walkToLeft() {
        if (walkedNode.left == null)
            throw IllegalStateException("Can't walk to left node")

        walkedNode = walkedNode.left!!
    }

    private fun walkToRight() {
        if (walkedNode.right == null)
            throw IllegalStateException("Can't walk to right node")

        walkedNode = walkedNode.right!!
    }

    fun reset() {
        walkedNode = node
    }
}