package analyzer.lib

import java.io.InputStream

class VolumetricAnalyzer() : Analyzable {
    override fun Analyze(stream: InputStream, metadata: Metadata): Metadata {
        metadata.size = 0

        val reader = stream.bufferedReader()

        reader.useLines { it.forEach {
            metadata.size+=it.length
        } }

        metadata.size *= metadata.encoding.bitsPerSymbol

        return metadata
    }
}