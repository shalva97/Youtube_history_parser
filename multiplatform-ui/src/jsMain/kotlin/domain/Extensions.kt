package domain

import androidx.compose.runtime.*
import com.darkrockstudios.libraries.mpfilepicker.FilePicker
import com.darkrockstudios.libraries.mpfilepicker.WebFile
import kotlinx.browser.document
import kotlinx.coroutines.launch
import models.HistoryFile
import org.w3c.dom.Document
import org.w3c.dom.HTMLInputElement
import org.w3c.dom.ItemArrayLike
import org.w3c.dom.asList
import org.w3c.files.File
import org.w3c.files.FileReader
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

@Composable
actual suspend fun selectAndParseFilesFromDisk(callback: (historyFile: HistoryFile) -> Unit) {
    var showFilePicker by remember { mutableStateOf(false) }
    val scope = rememberCoroutineScope()

    FilePicker(showFilePicker) { path ->
        showFilePicker = false
        scope.launch {
            val file = path as WebFile
            val historyFile = HistoryFile(file.path, file.getFileContents())
            callback.invoke(historyFile)
        }
    }
}

suspend fun readFileAsText(file: File) = suspendCoroutine {
    val reader = FileReader()
    reader.onload = { loadEvt ->
        val content = loadEvt.target.asDynamic().result as String
        it.resumeWith(Result.success(HistoryFile(file.name, content)))
    }
    reader.readAsText(file, "UTF-8")
}
