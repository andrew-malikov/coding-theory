package arithmetic.coding.lib

class Payload(codes: List<TokenRange>) {
    private val _content = mutableListOf<Double>()

    val content
        get() = _content.toList()

    init {
        codes.forEach {
            _content.add(it.average)
        }
    }
}