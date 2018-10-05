package ascii.lib.decoding

import java.lang.IllegalArgumentException

class DecimalDecodingStrategy : DecodingStrategy {
    override val symbolSize: Int = 3

    override fun decode(symbols: String): Int {
        if (symbols.length != symbolSize)
            throw IllegalArgumentException("Symbols can't be use with strategy")

        return symbols.toInt()
    }

}