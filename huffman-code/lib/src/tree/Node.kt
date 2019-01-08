package huffman.code.lib.tree

class Node : Comparable<Node> {
    var symbol: Char? = null

    var weight = 0
    var left: Node? = null

    var right: Node? = null

    fun isLeaf(): Boolean {
        return left == null && right == null && symbol != null
    }

    companion object {
        fun new(): FluentNodeBuilder {
            return FluentNodeBuilder(Node())
        }
    }

    fun setup(): FluentNodeBuilder {
        return FluentNodeBuilder(this)
    }

    override fun compareTo(other: Node): Int {
        return weight - other.weight
    }
}