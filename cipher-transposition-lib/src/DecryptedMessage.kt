package cipher.transposition.lib

class DecryptedMessage(encryptedBody: CharSequence, transpositions: Transpositions) {
    val content = EncryptedMessage(encryptedBody, transpositions.invert())
}