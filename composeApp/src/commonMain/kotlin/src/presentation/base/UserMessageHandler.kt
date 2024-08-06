package src.presentation.base

import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import core.UiEvent
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun UserMessageHandler(uiEvent: SharedFlow<UiEvent>, snackbarHostState: SnackbarHostState?) {
    LaunchedEffect(true) {
        snackbarHostState?.let { sbs ->
            uiEvent.collect { uiEvent ->
                when (uiEvent) {
                    is UiEvent.UserMessage -> uiEvent.message
                    is UiEvent.UserMessageEnum -> uiEvent.enum.toString()
                    else -> ""
                }.also { message -> sbs.showSnackbar(message) }
            }
        }
    }
}