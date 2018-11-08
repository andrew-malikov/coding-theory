package arithmetic.coding.lib

class Options(val codingLength: Int = 5) {
    init {
        var isValid = true

        if (codingLength < 2)
            isValid = false

        if (!isValid)
            throw IllegalStateException()
    }
}