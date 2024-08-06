package src.data.repository

import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.onStart
import src.core.datastructure.Resource
import src.data.darulIftaErrors
import src.data.datasource.DarulIftaDeobandLocalDataSource
import src.data.datasource.DarulIftaDeobandRemoteDataSource
import src.data.mockedQuestions
import src.domain.entity.QuestionAnswer
import src.domain.entity.QuestionAnswerDetail
import src.domain.repository.QuestionAnswerRepository

class QuestionAnswerRepositoryImpl(
    private val darulIftaDeobandLocalDataSource: DarulIftaDeobandLocalDataSource,
    private val darulIftaDeobandRemoteDataSource: DarulIftaDeobandRemoteDataSource,
) : QuestionAnswerRepository {
    override fun getQuestionAnswerDetails(questionId: Long) =
        flow<Resource<QuestionAnswerDetail>> {}

    override fun getQuestionList(page: Int) = flow<Resource<List<QuestionAnswer>>> {
        delay(840)
        val questions = mockedQuestions
        emit(Resource.Success(questions))
    }.catch { e ->
        emit(Resource.Error(e.darulIftaErrors))
    }.onStart {
        emit(Resource.Loading())
    }


    override fun getQuestionListByCategory(categoryId: Long) =
        flow<Resource<List<QuestionAnswer>>> {
            delay(840)
            val questions = mockedQuestions
            emit(Resource.Success(questions))
        }.catch { e ->
            emit(Resource.Error(e.darulIftaErrors))
        }.onStart {
            emit(Resource.Loading())
        }

    private var recentQuestionListCache = listOf<QuestionAnswer>()
    override val recentQuestionList: Flow<Resource<List<QuestionAnswer>>>
        get() = flow<Resource<List<QuestionAnswer>>> {
            delay(840)
            if (recentQuestionListCache.isEmpty()) {
                recentQuestionListCache = mockedQuestions
            }
            if (recentQuestionListCache.isNotEmpty()) {
                emit(Resource.Success(recentQuestionListCache))
            }
        }.catch { e ->
            emit(Resource.Error(e.darulIftaErrors))
        }.onStart {
            emit(Resource.Loading())
        }

    private var specialQuestionListCache = listOf<QuestionAnswer>()

    override val specialQuestionList: Flow<Resource<List<QuestionAnswer>>>
        get() = flow<Resource<List<QuestionAnswer>>> {
            delay(840)
            if (specialQuestionListCache.isEmpty()) {
                specialQuestionListCache = mockedQuestions
            }
            if (specialQuestionListCache.isNotEmpty()) {
                emit(Resource.Success(specialQuestionListCache))
            }
        }.catch { e ->
            emit(Resource.Error(e.darulIftaErrors))
        }.onStart {
            emit(Resource.Loading())
        }

    private var modernQuestionListCache = listOf<QuestionAnswer>()

    override val modernQuestionList: Flow<Resource<List<QuestionAnswer>>>
        get() = flow<Resource<List<QuestionAnswer>>> {
            delay(840)
            if (modernQuestionListCache.isEmpty()) {
                modernQuestionListCache = mockedQuestions
            }
            if (modernQuestionListCache.isNotEmpty()) {
                emit(Resource.Success(modernQuestionListCache))
            }
        }.catch { e ->
            emit(Resource.Error(e.darulIftaErrors))
        }.onStart {
            emit(Resource.Loading())
        }
}