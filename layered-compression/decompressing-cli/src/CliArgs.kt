package layered.compression.decompressing.cli

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
}
