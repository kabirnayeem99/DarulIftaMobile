package src.core.di

import org.koin.core.context.startKoin
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.module
import src.data.datasource.CategoryLocalDataSource
import src.data.datasource.DarulIftaDeobandLocalDataSource
import src.data.datasource.DarulIftaDeobandRemoteDataSource
import src.data.repository.CategoryRepositoryImpl
import src.data.repository.QuestionAnswerRepositoryImpl
import src.data.service.scraping.DarulIftaDeobandScrapingService
import src.data.service.scraping.HttpFetching
import src.domain.repository.CategoryRepository
import src.domain.repository.QuestionAnswerRepository


fun initKoin(appDeclaration: KoinAppDeclaration = {}) = startKoin {
    appDeclaration()
    modules(commonModule())
}

fun commonModule() =
    getUseCaseModule() + getServiceModule() + getDataSourceModule() + getRepositoryModule() + getHelperModule()


fun getHelperModule() = module {


}

fun getServiceModule() = module {
    single { HttpFetching() }
    single { DarulIftaDeobandScrapingService() }
}

fun getDataSourceModule() = module {
    factory { CategoryLocalDataSource(get()) }
    factory { DarulIftaDeobandLocalDataSource() }
    factory { DarulIftaDeobandRemoteDataSource(get(), get()) }
}

fun getRepositoryModule() = module {
    single<CategoryRepository> { CategoryRepositoryImpl(get()) }
    single<QuestionAnswerRepository> { QuestionAnswerRepositoryImpl(get(), get()) }
}

fun getUseCaseModule() = module {}