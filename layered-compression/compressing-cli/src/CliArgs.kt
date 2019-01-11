package layered.compression.compressing.cli

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default
import java.lang.IllegalArgumentException

class CliArgs(parser: ArgParser) {
    val registrySize by parser.storing("-r", "--registry-size",
            help = "[lzw]: initial size of token registry") { toInt() }
            .default(256)
            .addValidator {
                if (value <= 0)
                    throw IllegalArgumentException()
            }

    val codingLength by parser.storing(
            "-l",
            "--coding-length",
            help = "[arithmetic-coding]: length of one iteration of compression")
    { toInt() }.default(5)
}