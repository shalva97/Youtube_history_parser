package me.shalva97

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.ArrowDropDown
import androidx.compose.material.icons.rounded.CheckCircle
import androidx.compose.material.icons.rounded.List
import androidx.compose.material.icons.rounded.Settings
import androidx.compose.ui.graphics.vector.ImageVector

enum class Destinations(val title: String, val icon: ImageVector) {
    HISTORY("History", Icons.Rounded.List),
    STATS("Stats", Icons.Rounded.CheckCircle),
    DOWNLOADS("Downloads", Icons.Rounded.ArrowDropDown),
    SETTINGS("Settings", Icons.Rounded.Settings);
}