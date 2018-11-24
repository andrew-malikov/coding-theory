class RawMessage(body: List<Int>, registry: TokenRegistry) {
    private var _content = ""

    val content
        get() = _content

    init {
        var buffer = registry.getToken(body[0])
        _content = buffer

        var token: String
        for (i in 1 until body.size) {
            if (registry.hasCode(body[i])) token = registry.getToken(body[i])
            else token = buffer + buffer[0]

            _content += token
            registry.addToken(buffer + token[0])
            buffer = token
        }
    }
}