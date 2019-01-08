package huffman.code.lib.tree

import java.util.*

class NodeFactory {
    fun from(stats: Map<Char, Int>): Node {
        val queue = PriorityQueue<Node>()

        stats.forEach {
            queue.add(Node
                    .new()
                    .symbol(it.key)
                    .weight(it.value)
                    .build())
        }

        while (queue.size > 1) {
            val leftNode = queue.remove()
            val rightNode = queue.remove()

            queue.add(Node
                    .new()
                    .left(leftNode)
                    .right(rightNode)
                    .weight(leftNode.weight + rightNode.weight)
                    .build())
        }

        return queue.remove()
    }
}