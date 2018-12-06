package cipher.caeser.cli

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default

class CliArgs(parser: ArgParser) {
    val path by parser.storing("-p", "--path-to-file",
            help = "path to file")

    val shiftAmount by parser.storing(
            "-s", "--shift",
            help = "shift amount") { toInt() }

    val tokenSize by parser.storing(
            "-t", "--token-size",
            help = "token size") { toInt() }

    val mode by parser.mapping(
            "--encrypting" to AppMode.ENCRYPTING,
            "--decrypting" to AppMode.DECRYPTING,
            help = "app mode").default(AppMode.ENCRYPTING)
}