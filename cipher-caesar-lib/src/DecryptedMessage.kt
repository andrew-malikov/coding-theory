package cipher.ceaser.lib

class DecryptedMessage(encryptedMessage: CharSequence, options: CipherOptions) {
    private var _content = StringBuilder()

    val content
        get() = _content.toString()

    init {
        encryptedMessage.forEach {
            val symbolCode = (it.toInt() - options.shiftAmount + options.tokenSize) % options.tokenSize
            _content.append("${symbolCode.toChar()}")
        }
    }
}