package ascii.encoder.cli

import com.xenomachina.argparser.ArgParser

class EncoderArgs(parser: ArgParser) {
    val path by parser.storing("-p", "--path",
            help = "path to file")

    val type by parser.mapping(
            "--binary" to EncodingType.BINARY,
            "--decimal" to EncodingType.DECIMAL,
            "--hexadecimal" to EncodingType.HEXADECIMAL,
            help = "types for coding the symbols")
}