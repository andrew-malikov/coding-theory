package cipher.ceaser.lib

class CaesarCipherMessage(body: CharSequence, options: CipherOptions) {
    private var _content = StringBuilder()

    val content
        get() = _content.toString()

    init {
        body.forEach {
            _content.append(
                    ((it.toInt() + options.shiftAmount) % options.tokenSize).toChar()
            )
        }
    }
}