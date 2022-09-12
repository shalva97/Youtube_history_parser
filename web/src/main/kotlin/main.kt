import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import kotlinx.coroutines.launch
import org.jetbrains.compose.web.attributes.InputType
import org.jetbrains.compose.web.css.height
import org.jetbrains.compose.web.css.percent
import org.jetbrains.compose.web.css.vh
import org.jetbrains.compose.web.css.width
import org.jetbrains.compose.web.dom.*
import org.jetbrains.compose.web.renderComposable
import org.w3c.dom.asList
import org.w3c.files.Blob
import org.w3c.files.FileReader
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

fun main() {

    var textArea by mutableStateOf("Markdown formatted text will appear here")

    renderComposable(rootElementId = "root") {
        val scope = rememberCoroutineScope()
        Div {
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
                                textArea = YoutubeHistory(file.text()).toString()
                            }
                        }
                    }
                }
            }
            TextArea(textArea) {
                style {
                    width(90.percent)
                    height(90.vh)
                }
            }
        }
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
