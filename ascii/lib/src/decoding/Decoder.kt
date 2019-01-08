package ascii.lib.decoding

import java.lang.IllegalArgumentException

class Decoder(val strategy: DecodingStrategy) {
    fun decode(data: String): String {
        if (data.length % strategy.symbolSize != 0)
            throw IllegalArgumentException("Data is not valid for current strategy")

        val builder = StringBuilder()

        for (i in 0 until data.length step strategy.symbolSize) {
            val couple = data.substring(i, i + strategy.symbolSize)
            val number = strategy.decode(couple)

            if (number !in 0..255)
                throw IllegalArgumentException("Can't find code in ASCII codes")

            builder.append(number.toChar())
        }

        return builder.toString()
    }
}
