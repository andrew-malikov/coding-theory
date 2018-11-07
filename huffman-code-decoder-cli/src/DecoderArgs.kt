package huffman.code.decoder.cli

import com.xenomachina.argparser.ArgParser

class DecoderArgs(parser: ArgParser) {
    val path by parser.storing("-p", "--path",
            help = "path to the input file")
}