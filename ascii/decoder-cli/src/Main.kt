package ascii.decoder.cli

import ascii.lib.decoding.*

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody

import java.io.File

fun main(args: Array<String>) = mainBody {
    val parsedArgs = ArgParser(args).parseInto(::DecoderArgs)

    parsedArgs.run {
        val strategy: DecodingStrategy = DecimalDecodingStrategy()

        val data = truncate(File(path).readText())

        val decodedData = Decoder(strategy).decode(data)

        println(decodedData)
    }
}

fun truncate(data: String): String {
    return data.substring(0 until data.length-1)
}