package cipher.transposition.lib

class Transpositions(val values: List<Transposition>) {
    fun invert(): Transpositions {
        return Transpositions(values.map { it.invert() })
    }
}