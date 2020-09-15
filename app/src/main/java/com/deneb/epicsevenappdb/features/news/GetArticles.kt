package com.deneb.epicsevenappdb.features.news

import com.deneb.epicsevenappdb.core.exception.Failure
import com.deneb.epicsevenappdb.core.functional.Either
import com.deneb.epicsevenappdb.core.interactor.UseCaseFlow
import kotlinx.coroutines.flow.Flow

class GetArticles(private val articlesRepository: ArticlesRepository):
    UseCaseFlow<Either<Failure, List<Article>>,
            UseCaseFlow.None>() {
    override fun run(params: None?): Flow<Either<Failure, List<Article>>> = articlesRepository.getArticles()
}