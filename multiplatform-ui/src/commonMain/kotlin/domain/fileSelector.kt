package domain

import models.HistoryFile

expect fun selectAndParseFilesFromDisk(callback: (historyFile: HistoryFile) -> Unit)