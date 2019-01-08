package huffman.code.lib.tree

class FluentNodeBuilder(private val node: Node) {
    fun symbol(symbol: Char): FluentNodeBuilder {
        node.symbol = symbol
        return this
    }

    fun weight(weight: Int): FluentNodeBuilder {
        node.weight = weight
        return this
    }

    fun left(other: Node?): FluentNodeBuilder {
        node.left = other
        return this
    }

    fun right(other: Node?): FluentNodeBuilder {
        node.right = other
        return this
    }

    fun build(): Node {
        return node
    }
}