package huffman.code.lib

class ByteArrayEncoder {
    fun encode(data: String): ByteArray {
        val bytes = ByteArray(data.length / 8)

        for (i in 0 until data.length / 8)
            bytes[i] = Integer.parseInt(data.substring(i*8, (i+1)*8), 2).toByte()

        return bytes
    }
}