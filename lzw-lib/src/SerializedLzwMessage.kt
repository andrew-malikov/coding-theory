package lzw.lib

class SerializedLzwMessage(message: LzwMessage) {
    private var _content = ""

    val content
        get() = _content

    init {
        message.content.forEach {
            _content += it.toChar()
        }
    }
}