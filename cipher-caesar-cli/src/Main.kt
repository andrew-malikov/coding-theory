package cipher.caeser.cli

import java.io.File

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody

import cipher.ceaser.lib.CipherOptions
import cipher.ceaser.lib.CaesarCipherMessage
import cipher.ceaser.lib.DecryptedMessage

fun main(args: Array<String>) = mainBody {
    val parsedArgs = ArgParser(args).parseInto(::CliArgs)

    parsedArgs.run {
        val options = CipherOptions(tokenSize, shiftAmount)

        val message = File(path).readText()

        val result: String

        result = if (mode == AppMode.ENCRYPTING)
            CaesarCipherMessage(message, options).content
        else
            DecryptedMessage(message, options).content

        print(result)
    }
}