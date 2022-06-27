import models.YoutubeHistory
import picocli.CommandLine
import java.io.File
import java.util.concurrent.Callable
import kotlin.system.exitProcess

@CommandLine.Command(
    name = "Youtube History",
    mixinStandardHelpOptions = true,
    version = ["1.0.0"],
    description = ["Prints the statistics of your videos in a Markdown format"]
)
class CLI : Callable<Int> {

    @CommandLine.Parameters(description = ["File containing the history"])
    lateinit var historyJsonFile: File

    override fun call(): Int {

        val youtubeHistory = YoutubeHistory(
            resourcePath = historyJsonFile,
            minVideoClicks = 0
        )

        val results = StringBuilder().apply {
            append("# TOP 10")
            appendLine()
            append("### " + youtubeHistory.totalTimeWatchedForTopTenVideos())
            appendLine()
            append(youtubeHistory.getTopTenVideos())
            appendLine()
            append("### " + youtubeHistory.totalTimeWatched())
            appendLine()
            append(youtubeHistory.getMusicHistory())
        }

        println(results)
        return 0
    }
}

fun main(args: Array<String>): Unit = exitProcess(CommandLine(CLI()).execute(*args))
