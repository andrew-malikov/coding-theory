package arithmetic.coding.cli

import arithmetic.coding.lib.*

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody

fun main(args: Array<String>) = mainBody {
    val parsedArgs = ArgParser(args).parseInto(::CompressionArgs)

    parsedArgs.run {
        System.out.write(ArithmeticCodes(
                System.`in`.reader().readText(),
                Options(codingLength)).content.serialize()
        )
    }
}
