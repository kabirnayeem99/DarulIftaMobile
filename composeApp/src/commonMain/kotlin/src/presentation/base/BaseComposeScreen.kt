package src.presentation.base


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.graphics.Color
import core.UiEvent
import kotlinx.coroutines.flow.SharedFlow

@Composable
fun BaseComposeScreen(
    topBar: @Composable () -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    showLoading: Boolean = false,
    uiEvent: SharedFlow<UiEvent>,
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    content: @Composable (PaddingValues) -> Unit
) {
    val snackbarHostState = remember { SnackbarHostState() }
    Scaffold(
        topBar = topBar,
        snackbarHost = {
            SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = floatingActionButtonPosition,
        bottomBar = bottomBar,
    ) { scaffoldPadding ->
        if (showLoading) ProgressDialog()
        content(scaffoldPadding)
    }
    UserMessageHandler(uiEvent, snackbarHostState)
}

