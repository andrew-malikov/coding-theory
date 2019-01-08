package lzw.cli

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default

import java.lang.IllegalArgumentException

class CliArgs(parser: ArgParser) {
    val message by parser.storing("-m", "--message",
            help = "the content to proceeding")
            .addValidator {
                if (value.isEmpty())
                    throw IllegalArgumentException("put some chars!")
            }

    val registrySize by parser.storing("-s", "--size",
            help = "initial size of token registry") { toInt() }
            .default(256)
            .addValidator {
                if (value <= 0)
                    throw IllegalArgumentException()
            }

    val mode by parser.mapping(
            "--encoding" to AppMode.ENCODING,
            "--decoding" to AppMode.DECODING,
            help = "modes").default(AppMode.ENCODING)
}