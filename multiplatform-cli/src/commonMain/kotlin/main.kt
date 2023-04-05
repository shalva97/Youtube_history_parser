import kotlinx.cli.ArgParser
import kotlinx.cli.ArgType
import kotlinx.cli.vararg

fun main(args: Array<String>) {
    val parser = ArgParser("youtube-history-parser")
    val input by parser.argument(ArgType.String, description = "Youtube History json file").vararg()

    parser.parse(args)
    val inputData = readFrom(input)

    val markdown = YoutubeHistory(inputData.first())
    println(markdown)
}

expect fun readFrom(input: List<String>): List<String>
