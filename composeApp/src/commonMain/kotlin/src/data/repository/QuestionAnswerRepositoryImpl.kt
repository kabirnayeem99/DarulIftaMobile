package src.data.repository

import kotlinx.coroutines.flow.Flow
import src.core.datastructure.Resource
import src.data.datasource.DarulIftaDeobandLocalDataSource
import src.data.datasource.DarulIftaDeobandRemoteDataSource
import src.domain.entity.QuestionAnswer
import src.domain.entity.QuestionAnswerDetail
import src.domain.repository.QuestionAnswerRepository

class QuestionAnswerRepositoryImpl(
    private val darulIftaDeobandLocalDataSource: DarulIftaDeobandLocalDataSource,
    private val darulIftaDeobandRemoteDataSource: DarulIftaDeobandRemoteDataSource,
) : QuestionAnswerRepository {
    override fun getQuestionAnswerDetails(questionId: Long): Flow<Resource<QuestionAnswerDetail>> {
        val category =
        TODO("Not yet implemented")
    }

    override fun getQuestionList(page: Int): Flow<Resource<List<QuestionAnswer>>> {
        TODO("Not yet implemented")
    }

    override fun getQuestionListByCategory(categoryId: Long): Flow<Resource<List<QuestionAnswer>>> {
        TODO("Not yet implemented")
    }
}