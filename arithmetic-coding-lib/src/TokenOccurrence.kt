package arithmetic.coding.lib

class TokenOccurrence(data: CharSequence) {
    private val occurrence = mutableMapOf<Char, Int>()

    val content
        get() = occurrence.toMap()

    val frequencies: Map<Char, Double>
        get() {
            val messageLength = content.values.sum().toDouble()
            val frequencies = mutableMapOf<Char, Double>()

            occurrence.forEach {
                frequencies[it.key] = it.value / messageLength
            }

            return frequencies.toMap()
        }

    init {
        data.forEach {
            var count = 1

            if (occurrence.contains(it))
                count += occurrence[it]!!

            occurrence[it] = count
        }
    }
}