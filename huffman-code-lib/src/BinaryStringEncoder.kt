package huffman.code.lib

import java.lang.IllegalArgumentException

class BinaryStringEncoder {
    private fun getNormalizedBinaryString(data: String, size: Int): String {
        if (data.length < size)
            return data.padStart(size - data.length, '0')

        if (data.length > size)
            throw IllegalArgumentException()

        return data
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

    fun toBinaryString(data: Char, size: Int): String {
        return toBinaryString(data.toInt(), size)
    }
}