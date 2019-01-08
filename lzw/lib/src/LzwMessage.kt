package lzw.lib

class LzwMessage(body: String, registry: TokenRegistry) {
    private var _content = mutableListOf<Int>()

    val content
        get() = _content

    init {
        var buffer = ""

        body.forEach {
            val token = "$it"

            if (registry.hasToken(buffer + token))
                buffer += token
            else {
                _content.add(registry.getCode(buffer))
                registry.addToken(buffer + token)
                buffer = token
            }
        }

        _content.add(registry.getCode(buffer))
    }
}