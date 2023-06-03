package domain

import models.HistoryFile
import platform.AppKit.NSOpenPanel

actual suspend fun selectAndParseFilesFromDisk(): List<models.HistoryFile> {
    val openPanel = NSOpenPanel()
    openPanel.allowsMultipleSelection = false;
    openPanel.canChooseDirectories = false;
    openPanel.canCreateDirectories = false;
    openPanel.canChooseFiles = true;
    openPanel.runModal()

    println(openPanel.URL)

    return listOf( HistoryFile(openPanel.URL.toString(), ""))
}
