package arithmetic.coding.lib

class TokenFrequencies(data: CharSequence) {
    private val frequencies = mutableMapOf<Char, Double>()

    val content
        get() = frequencies.toMap()

    init {
        val baseFrequency = 1.0 / data.length

        data.forEach {
            var frequency = baseFrequency

            if (it in frequencies)
                frequency += frequencies[it]!!

            frequencies[it] = frequency
        }
    }
}