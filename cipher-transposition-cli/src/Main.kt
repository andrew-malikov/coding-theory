package cipher.transposition.cli

import cipher.transposition.lib.DecryptedMessage
import cipher.transposition.lib.EncryptedMessage

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody

import java.io.File

fun main(args: Array<String>) = mainBody {
    val parsedArgs = ArgParser(args).parseInto(::CliArgs)

    parsedArgs.run {
        val transpositions = TranspositionsFromJson(jsonTranspositions).content

        val message = File(path).readText()

        val result: String

        result = if (mode == AppMode.ENCRYPTING)
            EncryptedMessage(message, transpositions).content
        else
            DecryptedMessage(message, transpositions).content

        print(result)
    }
}