package arithmetic.coding.cli

import arithmetic.coding.lib.*

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody

import java.lang.IllegalArgumentException

fun main(args: Array<String>) = mainBody {
    val parsedArgs = ArgParser(args).parseInto(::EncoderArgs)

    parsedArgs.run {
        if (message.isEmpty())
            throw IllegalArgumentException()

        val codes = ArithmeticCodes(message, Options(5))

        val payload = Payload(codes.content)
        val header = Header(codes.messageMetadata.ranges, codes.codesMetadata)

        val decodedMessage = Message(payload.content, header)

        println("message")
        println(message)

        println("\ntoken ranges")
        showTokenRanges(codes.messageMetadata.ranges)

        println("\ntoken in the code: ${codes.codesMetadata.options.codingLength}")

        println("\nencoded message")
        showEncodedMessage(payload.content)

        println("\n\ndecoded message")
        println(decodedMessage.content)
    }
}

fun showTokenRanges(ranges: TokenRanges) {
    for (range in ranges.content) {
        println("${range.key} - ${range.value}")
    }
}

fun showEncodedMessage(codes: List<Double>) {
    codes.forEach {
        print("$it ")
    }
}

