package arithmetic.coding.lib

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.smile.SmileFactory

class CompressedData(
        val payload: List<Double>,
        val occurrence: Map<Char, Int>,
        val codingLength: Int,
        val restCodingLength: Int
) {
    fun serialize():  ByteArray = ObjectMapper(SmileFactory()).writeValueAsBytes(this)
}