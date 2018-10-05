package ascii.lib.encoding

class HexadecimalEncodingStrategy : EncodingStrategy {
    override fun encode(symbolNumber: Int): String {
        var hexadenary = symbolNumber.toHexString()

        while (hexadenary.length < 2)
            hexadenary = "0$hexadenary"

        return  hexadenary
    }
}

fun Int.toHexString() = Integer.toHexString(this)