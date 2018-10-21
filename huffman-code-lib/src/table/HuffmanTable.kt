package huffman.code.lib.table

class HuffmanTable() {
    fun computeCodes(stats: Map<Char, Int>, builder: TableCodeBuilder): Map<Char, Int> {
        val computed = mutableMapOf<Char, Int>()

        val nodes = getMergedNodes(getEmptyContainers(stats))

        computed[nodes[0].symbol] = builder.getBaseCode(nodes[0].length)

        var previousNode: Node = nodes[0]
        for (i in 1 until nodes.size) {
            var code = builder.getCode(computed[previousNode.symbol]!!)

            if (previousNode.length != nodes[i].length)
                code = builder.getBaseCode(nodes[i].length)

            computed[nodes[i].symbol] = code

            previousNode = nodes[i]
        }

        return computed
    }

    private fun getMergedNodes(inputContainers: MutableList<NodeContainer>): List<Node> {
        inputContainers.sortBy { it.weight }

        var containers = inputContainers
        while (containers.size > 1) {
            val merged = mutableListOf<NodeContainer>()

            for (i in 0 until containers.size step 2)
                merged.add(containers[i].merge(containers[i + 1]))

            if (containers.size % 2 == 1)
                merged.add(containers.last())

            containers = merged
        }

        return containers[0].nodes
    }

    private fun getEmptyContainers(stats: Map<Char, Int>): MutableList<NodeContainer> {
        val containers = mutableListOf<NodeContainer>()

        stats.forEach {
            containers.add(NodeContainer(nodes = listOf(Node(it.key, it.value))))
        }

        return containers
    }
}
