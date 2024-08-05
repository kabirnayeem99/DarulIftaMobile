package src.core.datastructure


sealed class Resource<T>(
    val data: T? = null,
    val messageEnum: Enum<*>? = null,
) {
    class Success<T>(data: T) : Resource<T>(data)
    class Loading<T>(data: T? = null) : Resource<T>(data)
    class Error<T>(messageEnum: Enum<*>?, data: T? = null) : Resource<T>(data, messageEnum)
}