package layered.compression.compressing.cli

import com.xenomachina.argparser.mainBody
import com.xenomachina.argparser.ArgParser

import lzw.lib.*
import arithmetic.coding.lib.*

fun main(args: Array<String>) = mainBody {
    val parsedArgs = ArgParser(args).parseInto(::CliArgs)

    parsedArgs.run {
        val lzwEncodedData = SerializedLzwMessage(LzwMessage(
                System.`in`.reader().readText(),
                TokenRegistry(registrySize))
        ).content

        System.out.write(
                ArithmeticCodes(
                        lzwEncodedData,
                        Options(codingLength)
                ).content.serialize()
        )
    }
}
