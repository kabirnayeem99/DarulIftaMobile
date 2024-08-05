package src.data.repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
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
    override fun getQuestionAnswerDetails(questionId: Long) =
        flow<Resource<QuestionAnswerDetail>> {}

    override fun getQuestionList(page: Int) = flow<Resource<List<QuestionAnswer>>> {}

    override fun getQuestionListByCategory(categoryId: Long) =
        flow<Resource<List<QuestionAnswer>>> {}

    override val recentQuestionList: Flow<Resource<List<QuestionAnswer>>>
        get() = flow {}
    override val specialQuestionList: Flow<Resource<List<QuestionAnswer>>>
        get() = flow {}
    override val modernQuestionList: Flow<Resource<List<QuestionAnswer>>>
        get() = flow {}
}