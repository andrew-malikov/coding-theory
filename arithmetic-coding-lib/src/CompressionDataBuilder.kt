package arithmetic.coding.lib

class CompressionDataBuilder(
        var payload: List<Double> = listOf(),
        var occurrence: Map<Char, Int> = mapOf(),
        var codingLength: Int = 5,
        var restCodingLength: Int = 5
) {
    fun build(): CompressedData {
        return CompressedData(payload, occurrence, codingLength, restCodingLength)
    }
}