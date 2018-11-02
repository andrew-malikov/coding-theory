package huffman.code.lib.specification

import huffman.code.lib.BinaryStringEncoder
import java.lang.StringBuilder

class HeaderBuilder(private val header: Header) {

    fun setSymbolLength(length: Byte): HeaderBuilder {
        header.symbolLength = length
        return this
    }

    fun setFrequencyLength(length: Byte): HeaderBuilder {
        header.frequencyLength = length
        return this
    }

    fun setSymbolCount(count: Short): HeaderBuilder {
        header.symbolCount = count
        return this
    }

    fun setEmptyBitCount(count: Byte): HeaderBuilder {
        header.emptyBitCount = count
        return this
    }

    fun setEmptyBitCount(payload: Payload): HeaderBuilder {
        header.emptyBitCount = (payload.data.length % 8).toByte()
        return this
    }

    fun setStatsTable(statsTable: String): HeaderBuilder {
        header.statsTable = statsTable
        return this
    }

    fun setStatsTable(statsTable: Map<Char, Int>, encoder: BinaryStringEncoder): HeaderBuilder {
        val builder = StringBuilder()

        statsTable.forEach {
            builder.append(encoder.toBinaryString(it.key, header.symbolLength.toInt()))
            builder.append(encoder.toBinaryString(it.value, header.frequencyLength.toInt()))
        }

        header.statsTable = builder.toString()

        return this
    }

    fun build(): Header {
        return header
    }
}