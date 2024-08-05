package src.presentation.home


import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.koin.koinNavigatorScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import core.UiEvent
import kotlinx.coroutines.flow.SharedFlow

class HomeScreen : Screen {
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = navigator.koinNavigatorScreenModel<HomeViewModel>()
        val uiState = viewModel.uiState.collectAsState()
        val snackbarHostState = remember { SnackbarHostState() }

        LaunchedEffect(uniqueScreenKey) {
            viewModel.fetchData()
            viewModel.uiEvent.handleUserMessage(snackbarHostState)
        }

        HomeView(
            uiState = uiState.value,
            snackbarHostState = snackbarHostState,
            onTabChanged = { tab -> viewModel.selectTab(tab) },
        )
    }

    private suspend fun SharedFlow<UiEvent>.handleUserMessage(snackbarHostState: SnackbarHostState?) {
        snackbarHostState?.let { sbs ->
            collect { uiEvent ->
                when (uiEvent) {
                    is UiEvent.UserMessage -> uiEvent.message
                    is UiEvent.UserMessageEnum -> uiEvent.enum.toString()
                    else -> ""
                }.also { message -> sbs.showSnackbar(message) }
            }
        }
    }
}