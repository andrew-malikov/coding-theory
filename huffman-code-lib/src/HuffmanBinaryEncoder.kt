package huffman.code.lib

import huffman.code.lib.specification.Header
import huffman.code.lib.table.TableCodeBuilder

class HuffmanBinaryEncoder {
    private val analyzer = SymbolAnalyzer()
    private val binaryStringEncoder = BinaryStringEncoder()
    private val byteArrayEncoder = ByteArrayEncoder()

    fun encode(sequence: CharSequence, symbolSizeInBits: Byte = 8): ByteArray {
        val stats = analyzer.analyze(sequence)

        val payload = PayloadEncoder(TableCodeBuilder()).encode(sequence, stats)
        val header = Header
                .create()
                .setSymbolLengthInBits(symbolSizeInBits)
                .setEmptyBitCount(payload)
                .setStatsTable(stats, binaryStringEncoder)
                .build()

        return byteArrayEncoder.encode(header.toBinaryString(binaryStringEncoder))
                .plus(byteArrayEncoder.encode(payload.toAlignBinaryString()))
    }
}