package huffman.code.lib

import huffman.code.lib.tree.Node
import huffman.code.lib.tree.NodeWalker

import java.lang.StringBuilder

class PayloadDecoder {
    fun decode(binary: CharSequence, tree: Node): CharSequence {
        val walker = NodeWalker(tree)
        val decoded = StringBuilder()

        binary.forEach {
            val maybeSymbol = walker.walk(it)

            if (maybeSymbol.isLeaf())
                decoded.append(maybeSymbol.symbol)
        }

        return decoded.toString()
    }
}