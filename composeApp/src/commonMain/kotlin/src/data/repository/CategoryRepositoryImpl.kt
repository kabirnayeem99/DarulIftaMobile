package src.data.repository

import kotlinx.coroutines.flow.Flow
import src.core.datastructure.Resource
import src.data.datasource.CategoryLocalDataSource
import src.domain.entity.Category
import src.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val categoryLocalDataSource: CategoryLocalDataSource,
) : CategoryRepository {
    override fun getSubCategories(rootCategoryId: Long): Flow<Resource<List<Category>>> {
        TODO("Not yet implemented")
    }

    override fun getRootCategories(): Flow<Resource<List<Category>>> {
        TODO("Not yet implemented")
    }
}