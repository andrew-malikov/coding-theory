package cipher.xor.lib

class EncryptedMessage(body: CharSequence, mask: Mask) {
    private var _content = StringBuilder()

    val content
        get() = _content.toString()

    init {
        body.forEach {
            _content.append(it.toInt().xor(mask.next()))
        }
    }
}