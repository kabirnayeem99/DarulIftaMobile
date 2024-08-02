import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import src.App

fun main() = application {
    Window(
        onCloseRequest = ::exitApplication,
        title = "DarulIftaMobile",
    ) {
        App()
    }
}