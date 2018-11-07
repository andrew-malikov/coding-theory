package huffman.code.lib

import java.lang.IllegalArgumentException

class BinaryStringEncoder {
    private fun getNormalizedBinaryString(binary: String, size: Int): String {
        if (binary.length < size)
            return binary.padStart(size, '0')

        if (binary.length > size)
            throw IllegalArgumentException()

        return binary
    }

    fun toBinaryString(data: Int, size: Int): String {
        return getNormalizedBinaryString(Integer.toBinaryString(data), size)
    }

    fun toBinaryString(data: Short, size: Int): String {
        return toBinaryString(data.toInt(), size)
    }

    fun toBinaryString(data: Byte, size: Int): String {
        return toBinaryString(data.toInt(), size)
    }

    fun byteToBinaryString(number: Byte, size: Int): String {
        if (number < 0)
            return Integer.toBinaryString(number.toInt()).subSequence(32-8, 32).toString()

        return getNormalizedBinaryString(number.toString(2), size)
    }

    fun toBinaryString(data: Char, size: Int): String {
        return toBinaryString(data.toInt(), size)
    }
}