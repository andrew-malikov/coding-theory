package huffman.code.lib.table

import huffman.code.lib.tree.Node

class Codes(private val node: Node) {

    private val _table = mutableMapOf<Char, String>()

    val table: Map<Char, String>
        get() = _table.toMap()

    init {
        collectCodes(node, "")
    }

    private fun collectCodes(node: Node, code: String) {
        if (node.left != null) {
            collectCodes(node.left!!, code + "0")
        }

        if (node.right != null) {
            collectCodes(node.right!!, code + "1")
        }

        if (node.isLeaf()) {
            _table[node.symbol!!] = code
        }
    }
}