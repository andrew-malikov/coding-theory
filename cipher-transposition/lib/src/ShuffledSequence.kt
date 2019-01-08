package cipher.transposition.lib

class ShuffledSequence(body: CharSequence, transpositions: List<Transposition>) {

    private val _content = StringBuilder()

    val content
        get() = _content.toString()

    init {
        _content.append(body)

        transpositions.forEach {
            swap(it)
        }
    }

    private fun swap(transposition: Transposition) {
        val buffer = _content[transposition.to]

        _content[transposition.to] = _content[transposition.from]
        _content[transposition.from] = buffer
    }
}