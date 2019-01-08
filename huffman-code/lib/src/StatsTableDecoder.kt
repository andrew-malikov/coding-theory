package huffman.code.lib

import huffman.code.lib.specification.Header

class StatsTableDecoder(private val encoder: BinaryStringEncoder) {
    fun decode(binary: ByteArray, header: Header): Map<Char, Int> {
        val stats = mutableMapOf<Char, Int>()

        for (i in 5 until header.statsTableSizeInBytes + 5 step header.bytesPerSymbol) {
            val symbol = StringBuilder()

            for (j in 0 until header.symbolLengthInBits / 8)
                symbol.append(encoder.toBinaryString(binary[i + j].toInt(), 8))

            val frequency = StringBuilder()

            val bytesPerSymbol = header.symbolLengthInBits / 8
            for (j in 0 until header.frequencyLengthInBits / 8)
                frequency.append(encoder.byteToBinaryString(binary[i + bytesPerSymbol + j], 8))

            stats[symbol.toString().toInt(2).toChar()] = frequency.toString().toInt(2)
        }

        return stats
    }
}