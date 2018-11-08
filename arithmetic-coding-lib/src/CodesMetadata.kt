package arithmetic.coding.lib

class CodesMetadata(data: CharSequence, val options: Options) {
    val lastCodeLength: Byte = calculateLastCodeLength(data)

    private fun calculateLastCodeLength(data: CharSequence): Byte {
        var length = data.length % options.codingLength

        if (length == 0 && data.isNotEmpty())
            length = options.codingLength

        return length.toByte()
    }
}