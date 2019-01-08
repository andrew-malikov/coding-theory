package huffman.code.lib

import huffman.code.lib.specification.Header
import huffman.code.lib.tree.NodeFactory

class HuffmanBinaryDecoder {
    private val binaryStringEncoder = BinaryStringEncoder()

    fun decode(binary: ByteArray): CharSequence {
        val header = Header
                .create()
                .from(binary)
                .build()

        val stats = StatsTableDecoder(binaryStringEncoder).decode(binary, header)
        val tree = NodeFactory().from(stats)

        val binaryStringPayload = ByteArrayDecoder(binaryStringEncoder).decode(binary.sliceArray((5 + header.statsTableSizeInBytes) until binary.size))

        return PayloadDecoder()
                .decode(binaryStringPayload
                        .subSequence(header.emptyBitCount.toInt(), binaryStringPayload.length), tree)
    }
}