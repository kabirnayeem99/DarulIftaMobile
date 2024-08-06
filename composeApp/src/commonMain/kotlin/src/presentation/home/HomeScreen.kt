package src.presentation.home


import androidx.compose.material3.SnackbarHostState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.remember
import cafe.adriel.voyager.core.annotation.ExperimentalVoyagerApi
import cafe.adriel.voyager.core.lifecycle.LifecycleEffectOnce
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.core.screen.uniqueScreenKey
import cafe.adriel.voyager.koin.koinNavigatorScreenModel
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import src.presentation.base.UserMessageHandler
import src.presentation.home.ui.HomeView

class HomeScreen : Screen {
    @OptIn(ExperimentalVoyagerApi::class)
    @Composable
    override fun Content() {
        val navigator = LocalNavigator.currentOrThrow
        val viewModel = navigator.koinNavigatorScreenModel<HomeViewModel>()
        val uiState = viewModel.uiState.collectAsState()
        val snackbarHostState = remember { SnackbarHostState() }

        LifecycleEffectOnce { viewModel.fetchData() }

        HomeView(
            uiState = uiState.value,
            uiEvent = viewModel.uiEvent,
            onTabChanged = { tab -> viewModel.selectTab(tab) },
        )

        UserMessageHandler(viewModel.uiEvent, snackbarHostState)
    }
}