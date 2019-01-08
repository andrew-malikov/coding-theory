package cipher.xor.cli

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.default

class CliArgs(parser: ArgParser) {
    val path by parser.storing("-p", "--path-to-file",
            help = "path to file")

    val mask by parser.storing(
            "-m", "--mask",
            help = "mask") { toInt() }

    val mode by parser.mapping(
            "--encrypting" to AppMode.ENCRYPTING,
            "--decrypting" to AppMode.DECRYPTING,
            help = "app mode").default(AppMode.ENCRYPTING)
}