package src.core

open class DarulIftaException(message: String) : Exception(message)

class EmptyHtmlException(override val message: String = "HTML content is empty or null") :
    DarulIftaException(message)

class FailedToParseException(
    html: String?,
    override val message: String = "Failed to parse HTML:\n$html"
) : DarulIftaException(message)