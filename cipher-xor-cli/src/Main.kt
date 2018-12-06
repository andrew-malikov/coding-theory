package cipher.xor.cli

import cipher.xor.lib.DecryptedMessage
import cipher.xor.lib.EncryptedMessage
import cipher.xor.lib.Mask

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody
import java.io.File

fun main(args: Array<String>) = mainBody {
    val parsedArgs = ArgParser(args).parseInto(::CliArgs)

    parsedArgs.run {
        val mask = Mask(mask, 16)

        val message = File(path).readText()

        val result: String

        result = if (mode == AppMode.ENCRYPTING)
            EncryptedMessage(message, mask).content
        else
            DecryptedMessage(message, mask).content

        print(result)
    }
}