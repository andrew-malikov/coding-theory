package arithmetic.coding.lib

class MessageMetadata(data: String) {
    private val _frequencies: TokenFrequencies = TokenFrequencies(data)

    val frequencies
        get() = _frequencies

    private val _ranges: TokenRanges = TokenRanges(_frequencies.content)

    val ranges
        get() = _ranges
}