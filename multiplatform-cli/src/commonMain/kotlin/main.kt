import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.required

fun main(args: Array<String>) {
    val parser = ArgParser("youtube-history-parser")
    val input by parser.option(ArgType.String, shortName = "i", description = "Youtube History json file").required()

    parser.parse(args)
    val inputData = readFrom(input)

    println(inputData)
}

expect fun readFrom(input: String): String
