package arithmetic.coding.lib

class CodesMetadata(data: String, val options: Options) {
    val lastCodeLength: Byte = (data.length % options.codingLength).toByte()
}