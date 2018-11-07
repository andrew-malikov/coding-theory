package huffman.code.decoder.cli

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody

import huffman.code.lib.HuffmanBinaryDecoder

import java.io.File
import java.lang.IllegalArgumentException

fun main(args: Array<String>) = mainBody {
    val parsedArgs = ArgParser(args).parseInto(::DecoderArgs)

    parsedArgs.run {
        if (path.isEmpty())
            throw IllegalArgumentException()

        val bytes = File(path).readBytes()

        print(HuffmanBinaryDecoder().decode(bytes))
    }
}