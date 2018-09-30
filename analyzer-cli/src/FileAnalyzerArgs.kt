package osu.labs.codingTheory.analyzerCli

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default

class FileAnalyzerArgs(parser: ArgParser) {
    val path by parser.storing("-p", "--path",
            help = "path to file")

    val bitsPerSymbol by parser.storing("-b", "--bits-per-symbol",
            help = "encoding of the file").default(8)

    val mode by parser.mapping(
            "--volumetric" to Mode.VOLUMETRIC,
            "--hartley" to Mode.HARTLEY,
            "--shannon" to Mode.SHANNON,
            help = "modes for calculating the file size")
}