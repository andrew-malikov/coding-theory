package common

class WritableByteBuffer() {
    private val storage = mutableListOf<Byte>()

    val content
        get() = storage.toMutableList()

    fun push(data: Byte) {
        storage.add(data)
    }

    fun push(data: Char) {
        push(data.toShort())
    }

    fun push(data: Short) {
        pushAsBinary(Integer.toBinaryString(data.toInt()).padStart(16, '0'))
    }

    fun push(data: Int) {
        pushAsBinary(Integer.toBinaryString(data).padStart(32, '0'))
    }

    fun pushAsOneByte(data: Int) {
        push(data.toByte())
    }

    fun pushAsOneByte(data: Short) {
        push(data.toByte())
    }

    fun pushAsBinary(binary: CharSequence) {
        if (binary.length % 8 != 0)
            throw IllegalArgumentException()

        for (i in 0 until binary.length / 8)
            push(Integer
                    .parseInt(binary.substring(i * 8 until (i + 1) * 8), 2)
                    .toByte()
            )
    }
}