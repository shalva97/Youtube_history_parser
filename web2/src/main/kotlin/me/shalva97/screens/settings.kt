package me.shalva97.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SettingsPage() {
    var maxNumberOfChar = 3
    var value by remember {
        mutableStateOf("10")
    }

    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp),
    ) {
        Row (
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
