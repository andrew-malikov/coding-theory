package arithmetic.coding.lib

import java.lang.IllegalArgumentException
import java.lang.IllegalStateException

import kotlin.math.min

class ChunkIterator(private val data: CharSequence, private val chunkSize: Int) : Iterator<CharSequence> {
    private var index = 0

    init {
        if (chunkSize < 0 || data.isEmpty())
            throw IllegalArgumentException()
    }

    override fun hasNext(): Boolean {
        return index < data.length
    }

    override fun next(): CharSequence {
        if (!hasNext())
            throw IllegalStateException()

        val chunk = data.slice(index until min(index + chunkSize, data.length))

        index += chunkSize

        return chunk
    }
}