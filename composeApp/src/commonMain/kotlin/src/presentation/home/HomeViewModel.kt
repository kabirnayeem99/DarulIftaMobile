package src.presentation.home

import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.screenModelScope
import core.UiEvent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.Job
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import src.core.datastructure.Resource
import src.core.safeCallAsync
import src.domain.repository.CategoryRepository
import src.domain.repository.QuestionAnswerRepository

class HomeViewModel(
    private val categoryRepository: CategoryRepository,
    private val questionAnswerRepository: QuestionAnswerRepository,
) : ScreenModel {
    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState = _uiState.asStateFlow()

    private val _uiEvent = MutableSharedFlow<UiEvent>()
    val uiEvent = _uiEvent.asSharedFlow()


    fun fetchData() {
        fetchCategories()
        uiState.value.tabOptions.forEach { tab -> fetchQuestions(tab) }
    }

    private fun fetchQuestions(tab: HomeUiState.Tab) {
        screenModelScope.launch(Dispatchers.IO) {
            safeCallAsync {
                when (tab) {
                    HomeUiState.Tab.Recent -> questionAnswerRepository.recentQuestionList
                    HomeUiState.Tab.Special -> questionAnswerRepository.specialQuestionList
                    HomeUiState.Tab.Modern -> questionAnswerRepository.modernQuestionList
                }.collectResource { questions ->
                    _uiState.update { us ->
                        when (tab) {
                            HomeUiState.Tab.Recent -> us.copy(recentQuestions = questions)
                            HomeUiState.Tab.Special -> us.copy(specialQuestions = questions)
                            HomeUiState.Tab.Modern -> us.copy(modernQuestions = questions)
                        }
                    }
                }
            }
        }
    }

    private var fetchCategoriesJob: Job? = null

    private fun fetchCategories() {
        fetchCategoriesJob?.cancel()
        fetchCategoriesJob = screenModelScope.launch(Dispatchers.IO) {
            safeCallAsync {
                categoryRepository.allCategories.collectResource { categories ->
                    _uiState.update { us -> us.copy(categories = categories) }
                }
            }
        }
    }

    private suspend fun <T> handleResource(
        resource: Resource<T>,
        onDataFound: suspend (T) -> Unit,
    ) {
        when (resource) {
            is Resource.Error -> showUserMessageEnum(resource.messageEnum)
            is Resource.Loading -> toggleLoading(true)
            is Resource.Success -> {
                toggleLoading(false)
                resource.data?.let { data -> onDataFound(data) }
            }
        }
    }

    private suspend fun <T> Flow<Resource<T>>.collectResource(collector: FlowCollector<T>) {
        collect { resource -> handleResource(resource) { d -> collector.emit(d) } }
    }

    private fun toggleLoading(loading: Boolean) {
        _uiState.update { us -> us.copy(isLoading = loading) }
    }

    fun selectTab(tab: HomeUiState.Tab) {
        screenModelScope.launch(Dispatchers.IO) {
            _uiState.update { us -> us.copy(selectedTab = tab) }
        }
    }


    private fun showUserMessageEnum(userMessageEnum: Enum<*>?) {
        screenModelScope.launch {
            toggleLoading(false)
            _uiEvent.emit(UiEvent.UserMessageEnum(userMessageEnum))
        }
    }
}