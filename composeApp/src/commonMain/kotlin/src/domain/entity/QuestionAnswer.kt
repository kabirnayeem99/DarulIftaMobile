package src.domain.entity

data class QuestionAnswer(
    val id: Long,
    val title: String,
    val question: String,
    val url: String,
    val categoryId: Long,
)
