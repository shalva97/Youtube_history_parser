package gui.domain

import androidx.compose.runtime.Composable
import gui.models.HistoryFile

@Composable
expect suspend fun selectAndParseFilesFromDisk(): List<HistoryFile>