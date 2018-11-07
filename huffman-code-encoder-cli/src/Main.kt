package huffman.code.encoder.cli

import huffman.code.lib.HuffmanBinaryEncoder

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody

import java.io.File
import java.lang.IllegalArgumentException

fun main(args: Array<String>) = mainBody {
    val parsedArgs = ArgParser(args).parseInto(::EncoderArgs)

    parsedArgs.run {
        if (inputPath.isEmpty())
            throw IllegalArgumentException()

        if (outputPath.isEmpty())
            throw IllegalArgumentException()

        val encodedFileDataInBytes = HuffmanBinaryEncoder().encode(File(inputPath).readText())

        File(outputPath).writeBytes(encodedFileDataInBytes)
    }
}