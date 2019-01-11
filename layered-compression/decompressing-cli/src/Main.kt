package layered.compression.decompressing.cli

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody

import arithmetic.coding.lib.*
import lzw.lib.*

fun main(args: Array<String>) = mainBody {
    val parsedArgs = ArgParser(args).parseInto(::CliArgs)

    parsedArgs.run {
        val decompressedArithmeticData = DecompressedData(
                CompressedDataFromBytes(System.`in`.readBytes()).deserialize()
        ).content

        println(decompressedArithmeticData)

        println(
                RawMessage(
                        DeserializedLzwMessage(decompressedArithmeticData).content,
                        TokenRegistry(registrySize)
                ).content
        )
    }
}
