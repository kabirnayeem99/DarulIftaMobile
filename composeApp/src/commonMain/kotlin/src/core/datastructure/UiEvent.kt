package core

sealed class UiEvent {
    data class UserMessage(val message: String) : UiEvent()
    data class UserMessageEnum(val enum: Enum<*>?) : UiEvent()
    data object OnLoggedIn : UiEvent()
}