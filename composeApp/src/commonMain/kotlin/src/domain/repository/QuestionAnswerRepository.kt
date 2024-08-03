package src.domain.repository

import kotlinx.coroutines.flow.Flow
import src.core.datastructure.Resource
import src.domain.entity.QuestionAnswer
import src.domain.entity.QuestionAnswerDetail

interface QuestionAnswerRepository {
    fun getQuestionAnswerDetails(questionId: Long): Flow<Resource<QuestionAnswerDetail>>

    fun getQuestionList(page: Int = 1): Flow<Resource<List<QuestionAnswer>>>

    fun getQuestionListByCategory(categoryId: Long): Flow<Resource<List<QuestionAnswer>>>
}