package gui.domain

import gui.models.HistoryFile
import java.awt.FileDialog
import java.awt.Frame
import java.io.File

actual suspend fun selectAndParseFilesFromDisk(): List<HistoryFile> {
    val selectedFile = FileDialog(null as? Frame, "Select history file", FileDialog.LOAD).apply {
        directory = System.getProperty("user.home") + "/Downloads/"
        isMultipleMode = true
        isVisible = true
    }
    return listOf(
        HistoryFile(selectedFile.file, File(selectedFile.directory, selectedFile.file).readText())
    )
}