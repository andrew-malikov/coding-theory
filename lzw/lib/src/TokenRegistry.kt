package lzw.lib

class TokenRegistry(size: Int) {
    private val _tokensToCodes = mutableMapOf<String, Int>()
    private val _codesToTokens = mutableMapOf<Int, String>()

    init {
        for (code in 0 until size) {
            _tokensToCodes["${code.toChar()}"] = code
            _codesToTokens[code] = "${code.toChar()}"
        }
    }

    fun addToken(token: String) {
        if (token in _tokensToCodes)
            throw IllegalArgumentException()

        val code = _tokensToCodes.size

        if (code in _codesToTokens)
            throw IllegalArgumentException()

        _tokensToCodes[token] = code
        _codesToTokens[code] = token
    }

    fun hasToken(token: String): Boolean {
        return token in _tokensToCodes
    }

    fun hasCode(code: Int): Boolean {
        return code in _codesToTokens
    }

    fun getToken(code: Int): String {
        val token = _codesToTokens[code]

        if (token == null)
            throw NoSuchElementException()

        return token
    }

    fun getCode(token: String): Int {
        val code = _tokensToCodes[token]

        if (code == null)
            throw NoSuchElementException()

        return code
    }
}