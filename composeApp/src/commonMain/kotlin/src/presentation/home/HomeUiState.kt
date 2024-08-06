package src.presentation.home

import androidx.compose.runtime.Stable
import src.domain.entity.Category
import src.domain.entity.QuestionAnswer

@Stable
data class HomeUiState(
    val selectedTab: Tab = Tab.Recent,
    val recentQuestions: List<QuestionAnswer> = emptyList(),
    val specialQuestions: List<QuestionAnswer> = emptyList(),
    val modernQuestions: List<QuestionAnswer> = emptyList(),
    val isLoading: Boolean = false,
    val categories: List<Category> = emptyList(),
) {
    enum class Tab {
        Recent, Special, Modern,
    }

    fun isTabSelected(tab: Tab) = tab == selectedTab

    val selectedTabIndex: Int
        get() = Tab.entries.indexOf(selectedTab)

    val tabOptions: List<Tab>
        get() = Tab.entries

}
