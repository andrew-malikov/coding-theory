package arithmetic.coding.cli

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default

class CompressionArgs(parser: ArgParser) {
    val codingLength by parser.storing(
            "-l",
            "--coding-length",
            help = "length of one iteration of compression")
    { toInt() }.default(5)

}
