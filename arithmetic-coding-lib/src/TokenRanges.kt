package arithmetic.coding.lib

import java.lang.IllegalArgumentException

class TokenRanges(frequencies: Map<Char, Double>) {
    private val ranges = mutableMapOf<Char, TokenRange>()

    val content
        get() = ranges.toMap()

    init {
        if (frequencies.isEmpty())
            throw IllegalArgumentException()

        var previousRange = TokenRange(0.0, frequencies.values.first())
        ranges[frequencies.keys.first()] = previousRange

        for (i in 1 until frequencies.size) {
            val range = previousRange.next(frequencies.values.elementAt(i))
            ranges[frequencies.keys.elementAt(i)] = range

            previousRange = range
        }
    }
}