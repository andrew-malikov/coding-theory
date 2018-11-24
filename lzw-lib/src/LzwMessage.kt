class LzwMessage(body: String, registry: TokenRegistry) {
    private var _content = mutableListOf<Int>()

    val content
        get() = _content

    init {
        var buffer = "$body[0]"

        for (i in 1 until body.length) {
            val token = "$body[i]"

            if (registry.hasToken(token))
                buffer += token
            else {
                _content.add(registry.getCode(buffer))
                registry.addToken(buffer + token)
                buffer = token
            }
        }
    }
}

/*

def encode(message, registry: TokenRegistry) -> str:
    output = []
    buffer = message[0]

    for i in range(1, len(message)):
        token = message[i]

        if registry.has_token(buffer + token):
            buffer += token
        else:
            output.append(registry.get_code(buffer))
            registry.append_token(buffer + token)
            buffer = token

    output.append(registry.get_code(buffer))

    return output

* */