package src.data.datasource

import src.data.service.scraping.StaticJsonLoaderService

class CategoryLocalDataSource(
    private val staticJsonLoaderService: StaticJsonLoaderService
) {
    suspend fun getDarulIftaDeobandCategories() =
        staticJsonLoaderService.getDarulIftaCategoryStaticData()
}