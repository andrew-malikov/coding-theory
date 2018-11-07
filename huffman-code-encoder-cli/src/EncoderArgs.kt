package huffman.code.encoder.cli

import com.xenomachina.argparser.ArgParser

class EncoderArgs(parser: ArgParser) {
    val inputPath by parser.storing("-p", "--path",
            help = "path to the input file")

    val outputPath by parser.storing("-o", "--output",
            help = "path to the output file")
}