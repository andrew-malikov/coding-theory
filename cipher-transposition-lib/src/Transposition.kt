package cipher.transposition.lib

/**
 *  Permutation of bits in 2 bytes
 *  Starts from 0
 * */
class Transposition(val from: Int, val to: Int) {
    init {
        if (from == to)
            throw IllegalArgumentException()
        if (!isInRange(from) || !isInRange(to))
            throw IllegalArgumentException()
    }

    private fun isInRange(number: Int): Boolean {
        return number in 0..15
    }

    fun invert(): Transposition {
        return Transposition(to, from)
    }
}