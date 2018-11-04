package huffman.code.lib.specification

/**
 * @param data should contain only 1 and 0
 * */
class Payload(val data: String) {
    val emptyBits
        get() = data.length % 8

    fun toAlignBinaryString(): String {
        return data.padStart(emptyBits, '0')
    }
}
