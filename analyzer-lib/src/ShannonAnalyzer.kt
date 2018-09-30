package osu.labs.codingTheory.analyzerLib

import java.io.InputStream

class ShannonAnalyzer : Analyzable {
    override fun Analyze(stream: InputStream, metadata: Metadata): Metadata {
        metadata.size = 0

        val reader = stream.bufferedReader()

        val symbols = mutableMapOf<Char, Int>()
        var length = 0

        reader.useLines { it.forEach {
            length += it.length
            it.forEach {
                var count = 1
                if (symbols.contains(it))
                    count += symbols[it]!!
                symbols[it] = count
            }
        } }

        var size = 0.0
        symbols.forEach {
            val probability = it.value/length.toDouble()
            size -= probability * Math.log(probability)
        }

        metadata.size = (length*size).toInt()

        return metadata
    }
}