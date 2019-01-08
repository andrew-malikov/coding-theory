package huffman.code.lib

import huffman.code.lib.specification.Payload

import java.lang.IllegalArgumentException
import java.lang.StringBuilder

class PayloadEncoder {
    fun encode(sequence: CharSequence, codes: Map<Char, String>): Payload {
        val result = StringBuilder()

        for (symbol in sequence) {
            val code = codes[symbol]

            if (code == null)
                throw IllegalArgumentException()

            result.append(code)
        }

        return Payload(result.toString())
    }


}