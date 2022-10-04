import androidx.compose.runtime.*
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.*
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.asList
import org.w3c.files.Blob
import org.w3c.files.FileReader
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun main() {

    var output by mutableStateOf("Markdown formatted text will appear here")
    var minVideoClicks by mutableStateOf(10)

    renderComposable(rootElementId = "root") {
        val scope = rememberCoroutineScope()
        Div {
            Label {
                Text("Select a JSON file:")
            }
            Br()
            Input(InputType.File) {
                onChange {
                    val file = it.target.files?.asList()?.first()

                    if (file != null) {
                        scope.launch {
                            output = try {
                                YoutubeHistory(file.text(), minVideoClicks).toString()
                            } catch (e: Exception) {
                                e.message ?: "Unknown Error"
                            }
                        }
                    }
                }
            }
            Text("Minimum video clicks: ")
            NumberInput(minVideoClicks) {
                style { width(100.px); height(1.em) }
                onInput { minVideoClicks = it.value!!.toInt() }
            }
        }

        TextArea(output) {
            style {
                width(90.percent)
                height(90.vh)
            }
        }
        VersionNumber()
    }
}

suspend fun Blob.text(): String = suspendCoroutine {
    FileReader().apply {
        onload = { _ ->
            it.resume(result as String)
        }
        onerror = { _ ->
            it.resumeWithException(Error("reading file: $this"))
        }
    }.readAsText(this)
}

@Composable
fun VersionNumber() {
    Div({
        style {
            position(Position.Absolute);
            bottom(10.px); right(10.px);
            width(100.percent);
            textAlign("right")
        }
    }) {
        Text("Version: " + "2.0.2") // TODO somehow get version name from Gradle
    }
}