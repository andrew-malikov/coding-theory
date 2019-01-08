package volume.analyzer.lib

import java.io.InputStream

class HartleyAnalyzer : Analyzable {
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

        metadata.size = (length * Math.log(symbols.size.toDouble())).toInt()

        return metadata
    }
}