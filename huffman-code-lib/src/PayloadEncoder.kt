package huffman.code.lib

import huffman.code.lib.specification.Payload
import huffman.code.lib.table.HuffmanTable
import huffman.code.lib.table.TableCodeBuilder

import java.lang.IllegalArgumentException
import java.lang.StringBuilder

class PayloadEncoder(private val codeBuilder: TableCodeBuilder) {
    fun encode(sequence: CharSequence, stats: Map<Char, Int>): Payload {
        val huffmanTable = HuffmanTable().computeCodes(stats, codeBuilder)

        val result = StringBuilder()

        for (symbol in sequence) {
            val code = huffmanTable[symbol]

            if (code == null)
                throw IllegalArgumentException()

            result.append(Integer.toBinaryString(code))
        }

        return Payload(result.toString())
    }


}