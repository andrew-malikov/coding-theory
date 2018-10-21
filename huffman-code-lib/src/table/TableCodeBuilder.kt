package huffman.code.lib.table

class TableCodeBuilder {
    fun getCode(previous: Int): Int {
        return previous + 0b1
    }

    fun getBaseCode(length: Int): Int {
        if (length == 1)
            return 0b0

        return Math.pow(0b10.toDouble(), length.toDouble() - 1).toInt()
    }
}