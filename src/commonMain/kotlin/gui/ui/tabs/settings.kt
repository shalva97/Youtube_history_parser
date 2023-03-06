package gui.ui.tabs

import androidx.compose.foundation.layout.*
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import gui.data.SettingsRepo
import org.kodein.di.compose.localDI
import org.kodein.di.instance

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SettingsScreen() {

    val settingsRepo: SettingsRepo by localDI().instance()

    val minVideoClicks by settingsRepo.minimumAmountOfVideoClicks.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize().padding(16.dp),
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Minimum video clicks:"
            )
            OutlinedTextField(modifier = Modifier.height(50.dp).width(150.dp),
                value = minVideoClicks.toString(),
                singleLine = true,
                onValueChange = { newText ->
                    if (newText.length <= MAX_NUMBER_OF_CHARS) {
                        settingsRepo.setMinClicks(newText.filter { it.isDigit() }.toInt())
                    }
                })
        }
    }
}

private const val MAX_NUMBER_OF_CHARS = 3