package arithmetic.coding.lib

import java.lang.StringBuilder

class Message(payload: List<Double>, private val header: Header) {
    private val _content = StringBuilder()

    val content
        get() = _content.toString()

    init {
        for (i in 0 until payload.size - 1)
            decode(payload[i])

        decode(payload.last(), header.codesMetadata.lastCodeLength)
    }

    private fun decode(code: Double, stepCount: Byte = header.codesMetadata.options.codingLength.toByte()) {
        var number = code

        for (i in 0 until stepCount) {
            val range = header.ranges.get(number)!!

            number = range.second.from(number)

            _content.append(range.first)
        }
    }
}