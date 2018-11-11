package arithmetic.coding.lib

class TokenRange(val min: Double, val max: Double) {
    val length
        get() = max - min

    val average
        get() = (min + max) / 2

    fun next(additionToMax: Double): TokenRange {
        return TokenRange(max, max + additionToMax)
    }

    fun contains(number: Double): Boolean {
        return number >= min && number < max
    }

    infix fun into(range: TokenRange): TokenRange {
        return TokenRange(range.min + range.length * min, range.min + range.length * max)
    }

    fun from(number: Double): Double {
        return (number - min) / (max - min)
    }

    override fun toString(): String {
        return "[$min, $max]"
    }
}
