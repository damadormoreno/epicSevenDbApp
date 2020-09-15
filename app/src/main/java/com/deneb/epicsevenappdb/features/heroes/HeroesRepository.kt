package com.deneb.epicsevenappdb.features.heroes

import android.content.SharedPreferences
import com.deneb.epicsevenappdb.core.exception.Failure
import com.deneb.epicsevenappdb.core.functional.Either
import com.deneb.epicsevenappdb.core.platform.NetworkHandler
import com.deneb.epicsevenappdb.core.functional.request
import com.deneb.epicsevenappdb.features.heroes.model.ResultHeroListApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

interface HeroesRepository {
    fun getHeroes(): Flow<Either<Failure, ResultHeroListApi>>

    class HeroesRepositoryImpl(
        private val networkHandler: NetworkHandler,
        private val service: HeroesService,
        private val shared: SharedPreferences
    ): HeroesRepository {
        override fun getHeroes(): Flow<Either<Failure, ResultHeroListApi>> {
            return flow {
                     when (networkHandler.isConnected) {
                        true -> emit(request(service.getHeros(), {it}, ResultHeroListApi.empty()))
                        false -> emit(Either.Left(Failure.NetworkConnection()))
                    }
            }.catch {
                emit(Either.Left(Failure.CustomError(it.stackTrace.hashCode(), it.localizedMessage)))
            }.flowOn(Dispatchers.IO)

        }

    }
}