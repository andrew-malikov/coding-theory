package lzw.cli

import lzw.lib.*

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody

fun main(args: Array<String>) = mainBody {
    val parsedArgs = ArgParser(args).parseInto(::CliArgs)

    parsedArgs.run {

        val output: String
        val registry = TokenRegistry(registrySize)

        output = if (mode == AppMode.ENCODING)
            SerializedLzwMessage(LzwMessage(message, registry)).content
        else RawMessage(DeserializedLzwMessage(message).content, registry).content

        println(output)
    }
}