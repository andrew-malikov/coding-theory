package arithmetic.coding.cli

import com.xenomachina.argparser.ArgParser

class EncoderArgs(parser: ArgParser) {
    val message by parser.storing("-m", "--message",
            help = "message for encoding")
}