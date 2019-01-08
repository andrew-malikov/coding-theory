package ascii.lib.encoding

class DecimalEncodingStrategy : EncodingStrategy {
    override fun encode(symbolNumber: Int): String {
        var denary = symbolNumber.toString()
        
        while (denary.length < 3)
            denary = "0$denary"
        
        return  denary
    }
}
