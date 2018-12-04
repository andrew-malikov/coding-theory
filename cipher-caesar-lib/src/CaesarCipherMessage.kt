package cipher.ceaser.lib

class CaesarCipherMessage(body: CharSequence, options: CipherOptions) {
    private var _content = ""

    val content
        get() = _content

    init {
        body.forEach {
            _content += (it.toInt() + options.shiftAmount) % options.tokenSize
        }
    }
}