package huffman.code.decompressing.cli

import com.xenomachina.argparser.ArgParser

class CliArgs(parser: ArgParser) {
    val path by parser.storing("-p", "--path",
            help = "path to the input file")
}