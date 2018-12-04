package cipher.ceaser.lib

class DecryptedMessage(encryptedMessage: CharSequence, options: CipherOptions) {
    private var _content = ""

    val content
        get() = _content

    init {
        encryptedMessage.forEach {
            val symbolCode = (it.toInt() - options.shiftAmount + options.tokenSize) % options.tokenSize
            _content += "${symbolCode.toChar()}"
        }
    }
}