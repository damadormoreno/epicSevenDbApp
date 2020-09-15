package com.deneb.epicsevenappdb.features.news

import com.deneb.epicsevenappdb.core.di.DefaultDispatcher
import com.deneb.epicsevenappdb.core.exception.Failure
import com.deneb.epicsevenappdb.core.functional.Either
import com.deneb.epicsevenappdb.core.interactor.FlowUseCase
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

open class GetArticlesFlow(
    private val articlesRepository: ArticlesRepository,
    @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
):
    FlowUseCase<Any, List<Article>>(defaultDispatcher) {
    override fun execute(parameters: Any): Flow<Either<Failure, List<Article>>> {
        return articlesRepository.getArticles()
        }
    }