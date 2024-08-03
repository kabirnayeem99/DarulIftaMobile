package src.data.service.scraping

import daruliftamobile.composeapp.generated.resources.Res
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.IO
import kotlinx.coroutines.withContext
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi
import src.data.service.scraping.dto.DarulIftaDeobandCategoriesDto

class StaticJsonLoaderService {
    @OptIn(ExperimentalResourceApi::class)
    suspend fun getDarulIftaCategoryStaticData(): DarulIftaDeobandCategoriesDto {
        return withContext(Dispatchers.IO) {
            val categoryJsonString =
                Res.readBytes("files/darul_ifta_deoband_categories.json").decodeToString()
            Json.decodeFromString(categoryJsonString)
        }
    }
}