package domain

import models.HistoryFile
import java.awt.FileDialog
import java.awt.Frame
import java.io.File

actual fun selectAndParseFilesFromDisk(callback: (historyFile: HistoryFile) -> Unit) {
    val selectedFile = FileDialog(null as? Frame, "Select history file", FileDialog.LOAD).apply {
        directory = System.getProperty("user.home") + "/Downloads/"
        isMultipleMode = true
        isVisible = true
    }
    listOf(
        HistoryFile(selectedFile.file, File(selectedFile.directory, selectedFile.file).readText())
    ) // TODO
}