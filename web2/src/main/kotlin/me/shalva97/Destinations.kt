package me.shalva97

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class Destinations(val title: String, val icon: ImageVector) {
    HISTORY("History", Icons.Filled.List),
    STATS("Stats", Icons.Filled.CheckCircle),
    DOWNLOADS("Downloads", Icons.Filled.ArrowDropDown),
    SETTINGS("Settings", Icons.Filled.Settings);
}