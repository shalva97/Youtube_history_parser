package domain

import models.HistoryFile

expect suspend fun selectAndParseFilesFromDisk(): List<HistoryFile>