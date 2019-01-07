package arithmetic.coding.lib

class CompressionMetadata(data: CharSequence, val options: Options) {
    val lastCodeLength: Int = calculateLastCodeLength(data)

    private fun calculateLastCodeLength(data: CharSequence): Int {
        var length = data.length % options.codingLength

        if (length == 0 && data.isNotEmpty())
            length = options.codingLength

        return length
    }
}