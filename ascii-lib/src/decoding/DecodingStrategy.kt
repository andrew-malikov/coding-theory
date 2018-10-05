package ascii.lib.decoding

interface DecodingStrategy {
    val symbolSize: Int

    fun decode(symbols: String): Int
}