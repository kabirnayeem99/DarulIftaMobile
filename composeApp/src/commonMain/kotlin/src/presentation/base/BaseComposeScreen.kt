package src.presentation.base


import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHost
import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

@Composable
fun BaseComposeScreen(
    topBar: @Composable () -> Unit = {},
    showLoading: Boolean = false,
    snackbarHostState: SnackbarHostState? = null,
    floatingActionButton: @Composable () -> Unit = {},
    floatingActionButtonPosition: FabPosition = FabPosition.End,
    content: @Composable (PaddingValues) -> Unit
) {
    Scaffold(
        topBar = topBar,
        snackbarHost = {
            if (snackbarHostState != null) SnackbarHost(hostState = snackbarHostState)
        },
        floatingActionButton = floatingActionButton,
        floatingActionButtonPosition = floatingActionButtonPosition,
    ) { scaffoldPadding ->
        if (showLoading) ProgressDialog()
        content(scaffoldPadding)
    }
}

