package cipher.transposition.lib

/**
 *  Representation of a 16-bit sequence
 * */
class BitSequenceFromInt(number: Int) {
    val content = Integer.toBinaryString(number).slice(16..31)
}