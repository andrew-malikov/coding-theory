package arithmetic.coding.lib

class TokenRange(val min: Double, val max: Double) {
    val length
        get() = max - min

    fun next(additionToMax: Double): TokenRange {
        return TokenRange(max, max + additionToMax)
    }

    infix fun into(range: TokenRange): TokenRange {
        return TokenRange(range.min + range.length * min, range.min + range.length * max)
    }
}
