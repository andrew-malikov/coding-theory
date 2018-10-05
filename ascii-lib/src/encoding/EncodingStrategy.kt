package ascii.lib.encoding

interface EncodingStrategy {
    fun encode(symbolNumber: Int): String
}