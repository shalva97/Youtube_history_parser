package models

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Download
import androidx.compose.material.icons.rounded.History
import androidx.compose.material.icons.rounded.Insights
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class HomeTab(val title: String, val icon: ImageVector) {
    MARKDOWN_HISTORY("Markdown", Icons.Rounded.History),
    COMPOSE_HISTORY("Compose", Icons.Rounded.History),
    STATS("Stats", Icons.Rounded.Insights),
    DOWNLOADS("Downloads", Icons.Rounded.Download),
    SETTINGS("Settings", Icons.Rounded.Settings);
}