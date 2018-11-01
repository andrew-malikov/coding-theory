package huffman.code.lib.table

class HuffmanTable {
    fun computeCodes(stats: Map<Char, Int>, builder: TableCodeBuilder): Map<Char, Int> {
        val table = mutableMapOf<Char, Int>()

        val nodes = getMergedNodes(getEmptyContainers(stats))

        table[nodes[0].symbol] = builder.getBaseCode(nodes[0].length)

        var previousNode: Node = nodes[0]
        for (i in 1 until nodes.size) {
            var code = builder.getCode(table[previousNode.symbol]!!)

            if (previousNode.length != nodes[i].length)
                code = builder.getBaseCode(nodes[i].length)

            table[nodes[i].symbol] = code

            previousNode = nodes[i]
        }

        return table
    }

    private fun getMergedNodes(containers: MutableList<NodeContainer>): List<Node> {
        containers.sortBy { it.weight }

        while (containers.size > 1) {
            val merged = containers.removeAt(0).merge(containers.removeAt(0))
            containers.add(merged)
            containers.sortBy { it.weight }
        }

        return containers[0].nodes
    }

    private fun getEmptyContainers(stats: Map<Char, Int>): MutableList<NodeContainer> {
        val containers = mutableListOf<NodeContainer>()

        stats.forEach {
            containers.add(NodeContainer(it.value, listOf(Node(it.key, 0))))
        }

        return containers
    }
}
