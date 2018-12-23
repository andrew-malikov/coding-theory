package common

import java.lang.IllegalStateException
import java.nio.ByteBuffer

class ReadableByteBuffer(private val bytes: List<Byte>) {
    // link to the next byte
    private var index = 0

    fun hasBytes(count: Int = 1) = index + count - 1 < bytes.size
    fun hasChars() = hasBytes(2)
    fun hasInts() = hasBytes(4)

    fun readByte(): Byte {
        if (!hasBytes())
            throw IllegalStateException()

        return bytes[index++]
    }

    fun readChar(): Char {
        if (!hasChars())
            throw  IllegalStateException()

        val result = ByteBuffer
                .wrap(ByteArray(2).plus(bytes.slice(index until index + 2)))
                .char

        index += 2

        return result
    }

    fun readShort(): Short {
        if (!hasChars())
            throw  IllegalStateException()

        val result = ByteBuffer
                .wrap(ByteArray(2).plus(bytes.slice(index until index + 2)))
                .short

        index += 2

        return result
    }

    fun readInt(): Int {
        if (!hasInts())
            throw  IllegalStateException()

        val result = ByteBuffer
                .wrap(ByteArray(4).plus(bytes.slice(index until index + 4)))
                .int

        index += 4

        return result
    }
}
