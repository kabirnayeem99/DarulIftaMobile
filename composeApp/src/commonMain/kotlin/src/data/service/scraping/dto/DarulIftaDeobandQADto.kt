package src.data.service.scraping.dto

data class DarulIftaDeobandQADto(
    val questionId: Long,
    val answerId: Long,
    val title: String,
    val question: String,
    val fatwaNo: String,
    val country: String,
    val answer: String,
    val rootCategory: String,
    val category: String,
)