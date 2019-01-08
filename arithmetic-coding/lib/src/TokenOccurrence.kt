package arithmetic.coding.lib

class TokenOccurrence(data: CharSequence) {
    private val occurrence = mutableMapOf<Char, Int>()

    val content
        get() = occurrence.toMap()

    init {
        data.forEach {
            var count = 1

            if (occurrence.contains(it))
                count += occurrence[it]!!

            occurrence[it] = count
        }
    }
}