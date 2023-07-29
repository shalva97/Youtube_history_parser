package domain

import models.HistoryFile
import org.w3c.files.File
import org.w3c.files.FileReader
import kotlin.coroutines.suspendCoroutine

actual fun selectAndParseFilesFromDisk(callback: (historyFile: HistoryFile) -> Unit) {
//    var showFilePicker by remember { mutableStateOf(false) }
//    val scope = rememberCoroutineScope()
//
//    FilePicker(showFilePicker) { path ->
//        showFilePicker = false
//        scope.launch {
//            val file = path as WebFile
//            val historyFile = HistoryFile(file.path, file.getFileContents())
//            callback.invoke(historyFile)
//        }
//    }
}

suspend fun readFileAsText(file: File) = suspendCoroutine {
    val reader = FileReader()
    reader.onload = { loadEvt ->
        val content = loadEvt.target.asDynamic().result as String
        it.resumeWith(Result.success(HistoryFile(file.name, content)))
    }
    reader.readAsText(file, "UTF-8")
}
