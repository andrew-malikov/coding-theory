package huffman.code.lib

import java.lang.StringBuilder

class ByteArrayDecoder(private val encoder: BinaryStringEncoder) {
    fun decode(binary: ByteArray): CharSequence {
        val decoded = StringBuilder()

        binary.forEach {
            decoded.append(encoder.byteToBinaryString(it, 8))
        }

        return decoded.toString()
    }
}