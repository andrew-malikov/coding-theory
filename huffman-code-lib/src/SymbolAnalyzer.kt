package huffman.code.lib

class SymbolAnalyzer {
    fun analyze(sequence: CharArray): Map<Char, Int> {
        val stats = mutableMapOf<Char, Int>()

        sequence.forEach {
            var count = 1

            if (stats.contains(it))
                count += stats[it]!!

            stats[it] = count
        }

        return stats
    }
}