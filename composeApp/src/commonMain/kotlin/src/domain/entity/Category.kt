package src.domain.entity

data class Category(
    val id: Long,
    val name: String,
    val rootCategoryId: Long,
)
