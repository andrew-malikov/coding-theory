package cipher.transposition.cli

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default

class CliArgs(parser: ArgParser) {
    val path by parser.storing("-p", "--path-to-file",
            help = "path to file")

    val jsonTranspositions by parser.storing(
            "-t", "--transpositions",
            help = "json format")

    val mode by parser.mapping(
            "--encrypting" to AppMode.ENCRYPTING,
            "--decrypting" to AppMode.DECRYPTING,
            help = "app mode").default(AppMode.ENCRYPTING)
}

