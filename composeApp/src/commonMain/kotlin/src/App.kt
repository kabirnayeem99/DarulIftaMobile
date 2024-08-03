package src

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.fleeksoft.ksoup.Ksoup
import org.jetbrains.compose.ui.tooling.preview.Preview

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext

@Composable
@Preview
fun App() {
    MaterialTheme {
        var count by remember { mutableIntStateOf(1) }
        LaunchedEffect(count) {
            withContext(Dispatchers.IO) {

            }
        }
        var showContent by remember { mutableStateOf(false) }
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            Button(onClick = {
                count += 1
                showContent = !showContent
            }) {

                Text("Click me!")
            }
            AnimatedVisibility(showContent) {

            }
        }
    }
}

