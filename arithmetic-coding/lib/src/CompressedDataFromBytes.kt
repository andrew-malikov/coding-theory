package arithmetic.coding.lib

import com.fasterxml.jackson.databind.ObjectMapper
import com.fasterxml.jackson.dataformat.smile.SmileFactory

class CompressedDataFromBytes(private val data: ByteArray) {
    fun deserialize(): CompressedData {
        return ObjectMapper(SmileFactory())
                .readValue(data, CompressionDataBuilder::class.java)
                .build()
    }
}