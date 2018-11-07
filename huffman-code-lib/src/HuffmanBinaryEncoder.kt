package huffman.code.lib

import huffman.code.lib.specification.Header
import huffman.code.lib.codes.Codes
import huffman.code.lib.tree.NodeFactory

class HuffmanBinaryEncoder {
    private val analyzer = SymbolAnalyzer()
    private val binaryStringEncoder = BinaryStringEncoder()
    private val byteArrayEncoder = ByteArrayEncoder()

    fun encode(sequence: CharSequence): ByteArray {
        val stats = analyzer.analyze(sequence)

        val tree = NodeFactory().from(stats)
        val codes = Codes(tree)

        val payload = PayloadEncoder().encode(sequence, codes.table)
        val header = Header
                .create()
                .setEmptyBitCount(payload)
                .setStatsTable(stats, binaryStringEncoder)
                .build()

        return byteArrayEncoder.encode(header.toBinaryString(binaryStringEncoder))
                .plus(byteArrayEncoder.encode(payload.toAlignBinaryString()))
    }
}