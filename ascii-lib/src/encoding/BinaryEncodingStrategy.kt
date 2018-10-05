package ascii.lib.encoding

class BinaryEncodingStrategy : EncodingStrategy {
    override fun encode(symbolNumber: Int): String {
        var binary = symbolNumber.toBinaryString()

        while (binary.length < 8)
            binary = "0$binary"

        return binary
    }
}

fun Int.toBinaryString() = Integer.toBinaryString(this)
