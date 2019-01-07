package arithmetic.coding.lib

class ArithmeticCodes(data: String, private val options: Options) {
    private var _content: CompressedData

    val content
        get() = _content

    init {
        val codes = mutableListOf<Double>()
        val ranges = data.ranges
        val iterator = ChunkIterator(data, options.codingLength)

        while (iterator.hasNext()) {
            val chunk = iterator.next()

            var range = ranges.get(chunk[0])
            for (i in 1 until chunk.length)
                range = ranges.get(chunk[i]) into range

            codes.add(range.average)
        }

        _content = CompressedData(
                codes,
                TokenOccurrence(data),
                options.codingLength,
                CompressionMetadata(data, options).lastCodeLength
        )
    }
}

val String.ranges: TokenRanges
    get() = TokenRanges(TokenFrequencies(this).content)

fun TokenRanges.get(token: Char): TokenRange = this.content.getValue(token)