package gui.domain

import gui.models.HistoryFile

expect suspend fun selectAndParseFilesFromDisk(): List<HistoryFile>