package huffman.code.lib.table

class NodeContainer(var weight: Int = 0, val nodes: List<Node> = listOf()) {
    fun merge(container: NodeContainer): NodeContainer {
        val mergedNodes = listOf<Node>().asSequence().plus(container.nodes).plus(nodes).toList()

        for (node in mergedNodes)
            node.increase()

        return NodeContainer(weight + container.weight, mergedNodes)
    }
}