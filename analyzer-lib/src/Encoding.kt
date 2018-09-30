package osu.labs.codingTheory.analyzerLib

import java.lang.IllegalArgumentException
import java.nio.charset.Charset

class Encoding(val bitsPerSymbol: Int) {

    var power:Double = Math.pow(2.0, bitsPerSymbol.toDouble())

    init {
        if (bitsPerSymbol < 1) throw IllegalArgumentException()
    }
}
