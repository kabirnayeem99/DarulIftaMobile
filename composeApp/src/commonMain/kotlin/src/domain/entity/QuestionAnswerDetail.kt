package src.domain.entity

data class QuestionAnswerDetail(
    val questionId: Long,
    val answerId: Long,
    val question: String,
    val answer: String,
    val title: String,
    val relatedQuestionIds: List<Long>,
    val url: String,
)