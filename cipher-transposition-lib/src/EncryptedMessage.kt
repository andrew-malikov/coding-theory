package cipher.transposition.lib

import java.lang.StringBuilder

class EncryptedMessage(body: CharSequence, transpositions: Transpositions) {
    private val _content = StringBuilder()

    val content
        get() = _content.toString()

    init {
        body.forEach {
            _content.append(getShuffledBits(it, transpositions).toInt(2).toChar())
        }
    }

    private fun getShuffledBits(symbol: Char, transpositions: Transpositions): String {
        return ShuffledSequence(getBits(symbol), transpositions.values).content
    }

    private fun getBits(symbol: Char): String {
        return BitSequenceFromInt(symbol.toInt()).content
    }
}