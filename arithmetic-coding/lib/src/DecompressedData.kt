package arithmetic.coding.lib

import com.fasterxml.jackson.annotation.JsonIgnore
import java.lang.StringBuilder

class DecompressedData(data: CompressedData) {
    private val _content = StringBuilder()

    val content
        get() = _content.toString()

    init {
        val ranges = data.occurrence.tokenRanges

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

val Map<Char, Int>.tokenRanges: TokenRanges
    @JsonIgnore
    get() {
        val messageLength = this.values.sum().toDouble()
        val frequencies = mutableMapOf<Char, Double>()

        this.forEach {
            frequencies[it.key] = it.value / messageLength
        }

        return TokenRanges(frequencies.toMap())
    }
