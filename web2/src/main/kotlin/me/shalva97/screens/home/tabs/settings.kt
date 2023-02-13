package me.shalva97.screens.home.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {
    var maxNumberOfChar = 3
    var value by remember {
        mutableStateOf("10")
    }

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Minimum video clicks:"
            )
            OutlinedTextField(
                modifier = Modifier.height(50.dp).width(150.dp),
                value = value,
                singleLine = true,
                onValueChange = { newText ->
                    if (newText.length <= maxNumberOfChar)
                        value = newText.filter { it.isDigit() }
                }
            )
        }
    }
}
