package lzw.lib

class DeserializedLzwMessage(body: String) {
    private var _content = mutableListOf<Int>()

    val content
        get() = _content

    init {
        body.forEach {
            _content.add(it.toInt())
        }
    }
}