package src.presentation


import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.unit.LayoutDirection
import cafe.adriel.voyager.navigator.Navigator
import org.jetbrains.compose.ui.tooling.preview.Preview
import org.koin.compose.KoinContext
import src.presentation.home.HomeScreen

import src.presentation.theme.AppTheme

@Composable
@Preview
fun App() {
    KoinContext {
        AppTheme {
            CompositionLocalProvider(LocalLayoutDirection provides LayoutDirection.Rtl) {
                Navigator(HomeScreen())
            }
        }
    }
}

