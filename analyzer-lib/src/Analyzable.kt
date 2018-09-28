package osu.labs.codingTheory.analyzerLib

import java.io.InputStream

interface Analyzable {
    fun Analyze(stream: InputStream, metadata: Metadata): Metadata
}