package ascii.encoder.cli

import ascii.lib.encoding.*

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody

import java.io.File

fun main(args: Array<String>) = mainBody {
    val parsedArgs = ArgParser(args).parseInto(::EncoderArgs)

    parsedArgs.run {
        var strategy: EncodingStrategy = BinaryEncodingStrategy()

        if (type == EncodingType.DECIMAL)
            strategy = DecimalEncodingStrategy()

        if (type == EncodingType.HEXADECIMAL)
            strategy = HexadecimalEncodingStrategy()

        File(path).inputStream()

        val encodedData = Encoder(strategy).encode(File(path).inputStream().readBytes())

        println(encodedData)
    }
}