package huffman.code.lib

class ByteArrayEncoder {
    fun encode(data: String): ByteArray {
        val bytes = ByteArray(data.length)

        for (i in 0 until data.length / 8)
            bytes[i] = Integer.parseInt(data.substring(i, i + 8), 2).toByte()

        return bytes
    }
}