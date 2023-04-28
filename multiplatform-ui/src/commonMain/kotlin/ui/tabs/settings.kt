package ui.tabs

import Youtube_history_parser.parser.BuildConfig
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import data.SettingsRepo
import org.kodein.di.compose.localDI
import org.kodein.di.instance

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {

    val settingsRepo: SettingsRepo by localDI().instance()
    var minVideoClicks by remember {
        mutableStateOf(settingsRepo.minimumAmountOfVideoClicks.value.toString())
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
            OutlinedTextField(modifier = Modifier.width(150.dp).padding(horizontal = 16.dp),
                value = minVideoClicks,
                singleLine = true,
                onValueChange = { newText ->
                    if (newText.length <= MAX_NUMBER_OF_CHARS) {
                        minVideoClicks = newText
                    }
                })
            Button(onClick = {
                settingsRepo.setMinClicks(minVideoClicks.toInt())
            }) {
                Text("Apply")
            }
        }
        Row {
            Text("Version ${BuildConfig.APP_VERSION}")
        }
    }
}

private const val MAX_NUMBER_OF_CHARS = 3