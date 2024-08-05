package src.presentation.home.ui

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import daruliftamobile.composeapp.generated.resources.Res
import daruliftamobile.composeapp.generated.resources.modern_fatwa_label
import daruliftamobile.composeapp.generated.resources.recent_fatwa_label
import daruliftamobile.composeapp.generated.resources.special_fatwa_label
import org.jetbrains.compose.resources.stringResource
import src.presentation.base.BaseComposeScreen
import src.presentation.home.HomeUiState

@Composable
fun HomeView(
    uiState: HomeUiState,
    snackbarHostState: SnackbarHostState? = null,
    onTabChanged: (HomeUiState.Tab) -> Unit = {},
) {
    BaseComposeScreen(
        snackbarHostState = snackbarHostState,
    ) { scaffoldPadding ->

        Column(
            modifier = Modifier.padding(scaffoldPadding).fillMaxSize(),
        ) {
            TabRow(selectedTabIndex = uiState.selectedTabIndex) {
                uiState.tabOptions.forEach { tab ->
                    val title = when (tab) {
                        HomeUiState.Tab.Recent -> stringResource(Res.string.recent_fatwa_label)
                        HomeUiState.Tab.Special -> stringResource(Res.string.special_fatwa_label)
                        HomeUiState.Tab.Modern -> stringResource(Res.string.modern_fatwa_label)
                    }

                    Tab(
                        text = { Text(title) },
                        selected = uiState.isTabSelected(tab),
                        onClick = { onTabChanged(tab) },
                    )
                }
            }

            when (uiState.selectedTab) {
                HomeUiState.Tab.Recent -> FatwaByCategoryTab(uiState.recentQuestions)
                HomeUiState.Tab.Special -> FatwaByCategoryTab(uiState.specialQuestions)
                HomeUiState.Tab.Modern -> FatwaByCategoryTab(uiState.modernQuestions)
            }
        }
    }
}