package cipher.xor.lib

class DecryptedMessage(encryptedBody: CharSequence, mask: Mask) {
    private var _content = StringBuilder()

    val content
        get() = _content.toString()

    init {
        encryptedBody.forEach {
            _content.append(it.toInt().xor(mask.next()).toChar())
        }
    }
}