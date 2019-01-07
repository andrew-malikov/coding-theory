package arithmetic.coding.lib

import java.lang.StringBuilder

class Message(data: CompressedData) {
    private val _content = StringBuilder()

    val content
        get() = _content.toString()

    init {
        val ranges = data.tokenRanges

        for (i in 0 until data.payload.size - 1)
            decode(ranges, data.payload[i], data.codingLength)

        decode(ranges, data.payload.last(), data.restCodingLength)
    }

    private fun decode(ranges: TokenRanges, code: Double, stepCount: Int) {
        var number = code

        for (i in 0 until stepCount) {
            val range = ranges.get(number)!!

            number = range.second.from(number)

            _content.append(range.first)
        }
    }
}

val CompressedData.tokenRanges: TokenRanges
    get() = TokenRanges(this.occurrence.frequencies)
