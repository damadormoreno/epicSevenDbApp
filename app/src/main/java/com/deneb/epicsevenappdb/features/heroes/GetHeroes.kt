package com.deneb.epicsevenappdb.features.heroes

import com.deneb.epicsevenappdb.core.di.DefaultDispatcher
import com.deneb.epicsevenappdb.core.exception.Failure
import com.deneb.epicsevenappdb.core.functional.Either
import com.deneb.epicsevenappdb.core.interactor.FlowUseCase
import com.deneb.epicsevenappdb.features.heroes.model.ResultHeroListApi
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.Flow

open class GetHeroes(
    private val heroesRepository: HeroesRepository,
    @DefaultDispatcher defaultDispatcher: CoroutineDispatcher
): FlowUseCase<Any, ResultHeroListApi>(defaultDispatcher) {
    override fun execute(parameters: Any): Flow<Either<Failure, ResultHeroListApi>> {
        return heroesRepository.getHeroes()
    }

}