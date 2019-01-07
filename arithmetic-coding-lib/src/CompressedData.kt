package arithmetic.coding.lib

import com.fasterxml.jackson.dataformat.ion.IonObjectMapper

class CompressedData(
        val payload: List<Double>,
        val occurrence: TokenOccurrence,
        val codingLength: Int,
        val restCodingLength: Int
) {
    fun serialize(): ByteArray = IonObjectMapper().writeValueAsBytes(this)
}