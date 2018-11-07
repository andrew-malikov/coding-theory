package ascii.lib.encoding

import java.lang.StringBuilder

class Encoder(val strategy: EncodingStrategy) {
    fun encode(data: ByteArray): String {
        val builder = StringBuilder()

        data.forEach {
            if (it < 0 || it > 255)
                throw IllegalArgumentException("Can't find bytes `$it` in ASCII codes")

            builder.append(strategy.encode(it.toInt()))
        }

        return builder.toString()
    }
}