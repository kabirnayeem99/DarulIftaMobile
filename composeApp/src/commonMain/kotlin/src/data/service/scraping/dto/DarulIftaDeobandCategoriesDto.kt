package src.data.service.scraping.dto


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class DarulIftaDeobandCategoriesDto(
    @SerialName("categories") val categories: List<Category?>? = null
) {
    @Serializable
    data class Category(
        @SerialName("category_name") val categoryName: String? = null, // Faiths & Beliefs
        @SerialName("sub_categories") val subCategories: List<SubCategory?>? = null
    ) {
        @Serializable
        data class SubCategory(
            @SerialName("name") val name: String? = null, // Islamic Beliefs
            @SerialName("url") val url: String? = null // https://darulifta-deoband.com/home/qa/islamic-beliefs/1
        )
    }
}