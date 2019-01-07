package arithmetic.coding.lib

import com.fasterxml.jackson.dataformat.ion.IonObjectMapper

class CompressedDataFromBytes(private val data: ByteArray) {
    fun deserialize(): CompressedData {
        return IonObjectMapper().readValue(data, CompressedData::class.java)
    }
}