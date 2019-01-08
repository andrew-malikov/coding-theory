package cipher.transposition.lib

class Transpositions(val values: List<Transposition>) {
    fun reverse(): Transpositions {
        return Transpositions(values.reversed())
    }
}