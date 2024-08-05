package src.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import src.core.datastructure.Resource
import src.data.datasource.CategoryLocalDataSource
import src.domain.entity.Category
import src.domain.repository.CategoryRepository

class CategoryRepositoryImpl(
    private val categoryLocalDataSource: CategoryLocalDataSource,
) : CategoryRepository {

    val categories = mutableListOf<Category>()

    override fun getSubCategories(rootCategoryId: Long) = flow<Resource<List<Category>>> {  }

    override val allCategories: Flow<Resource<List<Category>>>
        get() =  flow {  }

}