package huffman.code.lib.table

data class Node(var symbol: Char, var length: Int) {
    fun increase(value: Int = 1) {
        length += value
    }
}