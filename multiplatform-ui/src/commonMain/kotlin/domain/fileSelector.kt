package domain

import androidx.compose.runtime.Composable
import models.HistoryFile

@Composable
expect fun selectAndParseFilesFromDisk(callback: (historyFile: HistoryFile) -> Unit)