package arithmetic.coding.lib

class ArithmeticCodes(data: String, private val options: Options) {
    private val _messageMetadata = MessageMetadata(data)

    val messageMetadata
        get() = _messageMetadata

    private val _codesMetadata = CodesMetadata(data, options)

    val codesMetadata
        get() = _codesMetadata

    private val codes = mutableListOf<TokenRange>()

    val content
        get() = codes.toList()

    init {
        val iterator = ChunkIterator(data, options.codingLength)

        while (iterator.hasNext()) {
            val chunk = iterator.next()

            var range = getRange(chunk[0])
            for (i in 1 until chunk.length)
                range = getRange(chunk[i]) into range

            codes.add(range)
        }
    }

    private fun getRange(token: Char): TokenRange {
        return _messageMetadata.ranges.content.getValue(token)
    }
}