package analyzer.cli

import com.xenomachina.argparser.ArgParser
import com.xenomachina.argparser.mainBody

import analyzer.lib.*
import java.io.File

fun main(args: Array<String>) = mainBody {
    val parsedArgs = ArgParser(args).parseInto(::FileAnalyzerArgs)

    parsedArgs.run {
        val metadata = Metadata(path, Encoding(bitsPerSymbol.toString().toInt()))

        var analyzer: Analyzable = VolumetricAnalyzer()

        if (mode == Mode.HARTLEY)
            analyzer = HartleyAnalyzer()

        if (mode == Mode.SHANNON)
            analyzer = ShannonAnalyzer()

        analyzer.Analyze(File(path).inputStream(), metadata)

        println("file size: ${metadata.size} bits")
    }
}