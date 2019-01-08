package ascii.decoder.cli

import com.xenomachina.argparser.ArgParser

class DecoderArgs(val parser: ArgParser) {
    val path by parser.storing("-p", "--path",
            help = "path to file")

    val type by parser.mapping(
            "--decimal" to EncodingType.DECIMAL,
            help = "types for decoding the symbols")
}