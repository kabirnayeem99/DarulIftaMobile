package src.core.di

import org.koin.core.KoinApplication
import org.koin.core.context.startKoin
import src.presentation.home.HomeViewModel
import org.koin.core.module.dsl.factoryOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.KoinAppDeclaration
import org.koin.dsl.bind
import org.koin.dsl.module
import src.data.datasource.CategoryLocalDataSource
import src.data.datasource.DarulIftaDeobandLocalDataSource
import src.data.datasource.DarulIftaDeobandRemoteDataSource
import src.data.repository.CategoryRepositoryImpl
import src.data.repository.QuestionAnswerRepositoryImpl
import src.data.service.scraping.DarulIftaDeobandScrapingService
import src.data.service.scraping.StaticJsonLoaderService
import src.data.service.scraping.HttpFetching
import src.domain.repository.CategoryRepository
import src.domain.repository.QuestionAnswerRepository


fun initKoin(appDeclaration: KoinAppDeclaration = {}) {
    startKoin {
        appDeclaration()
        modules(commonModule())
    }
}

fun commonModule() =
    getUseCaseModule() + getServiceModule() + getDataSourceModule() + getRepositoryModule() + getViewModelModule()


fun getViewModelModule() = module {
    factoryOf(::HomeViewModel)
}


fun getServiceModule() = module {
    singleOf(::HttpFetching)
    singleOf(::DarulIftaDeobandScrapingService)
    singleOf(::StaticJsonLoaderService)
}

fun getDataSourceModule() = module {
    factoryOf(::CategoryLocalDataSource)
    factoryOf(::DarulIftaDeobandLocalDataSource)
    factoryOf(::DarulIftaDeobandRemoteDataSource)
}

fun getRepositoryModule() = module {
    singleOf(::CategoryRepositoryImpl).bind<CategoryRepository>()
    singleOf(::QuestionAnswerRepositoryImpl).bind<QuestionAnswerRepository>()
}

fun getUseCaseModule() = module {}