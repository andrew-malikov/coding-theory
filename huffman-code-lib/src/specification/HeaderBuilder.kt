package huffman.code.lib.specification

import huffman.code.lib.BinaryStringEncoder

import java.lang.StringBuilder
import java.nio.ByteBuffer

class HeaderBuilder(private val header: Header) {

    fun setSymbolLengthInBits(length: Byte): HeaderBuilder {
        header.symbolLengthInBits = length
        return this
    }

    fun setFrequencyLengthInBits(length: Byte): HeaderBuilder {
        header.frequencyLengthInBits = length
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
        header.emptyBitCount = payload.emptyBits.toByte()
        return this
    }

    fun setStatsTable(statsTable: String): HeaderBuilder {
        header.statsTable = statsTable
        return this
    }

    fun setStatsTable(statsTable: Map<Char, Int>, encoder: BinaryStringEncoder): HeaderBuilder {
        val table = StringBuilder()

        statsTable.forEach {
            table
                    .append(encoder.toBinaryString(it.key, header.symbolLengthInBits.toInt()))
                    .append(encoder.toBinaryString(it.value, header.frequencyLengthInBits.toInt()))
        }

        header.statsTable = table.toString()
        header.symbolCount = statsTable.size.toShort()

        return this
    }

    fun from(binary: ByteArray): HeaderBuilder {
        setSymbolLengthInBits(binary[0])
        setFrequencyLengthInBits(binary[1])
        setSymbolCount(ByteBuffer.wrap(byteArrayOf(binary[2], binary[3])).short)
        setEmptyBitCount(binary[4])
        return this
    }

    fun build(): Header {
        return header
    }
}