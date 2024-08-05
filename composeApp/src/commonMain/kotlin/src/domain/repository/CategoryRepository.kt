package src.domain.repository

import kotlinx.coroutines.flow.Flow
import src.core.datastructure.Resource
import src.domain.entity.Category

interface CategoryRepository {
    fun getSubCategories(rootCategoryId: Long): Flow<Resource<List<Category>>>
    val allCategories: Flow<Resource<List<Category>>>
}