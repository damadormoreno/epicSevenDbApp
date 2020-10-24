package com.deneb.epicsevenappdb.features.heroes

import android.content.SharedPreferences
import com.deneb.epicsevenappdb.core.exception.Failure
import com.deneb.epicsevenappdb.core.extensions.SharedPrefences.set
import com.deneb.epicsevenappdb.core.functional.Either
import com.deneb.epicsevenappdb.core.functional.request
import com.deneb.epicsevenappdb.core.platform.NetworkHandler
import com.deneb.epicsevenappdb.core.platform.ServiceKOs
import com.deneb.epicsevenappdb.features.heroes.model.HeroEntity
import com.deneb.epicsevenappdb.features.heroes.model.ResultApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.util.*

interface HeroesRepository {
    fun getHeroes(): Flow<Either<Failure, List<HeroEntity>>>

    class HeroesRepositoryImpl(
        private val networkHandler: NetworkHandler,
        private val service: HeroesService,
        private val shared: SharedPreferences,
        private val heroesDB: HeroesLocal
    ): HeroesRepository {

        override fun getHeroes(): Flow<Either<Failure, List<HeroEntity>>> {
            return flow {
                val heroes = heroesDB.getHeroes()
                val time = shared.getLong("time", 0)
                if (heroes.isNullOrEmpty()
                    || time == 0
                    || isFetchCurrentNeeded(shared.getLong("time", 0))) {
                    emit(getHeroesApi())
                }else {
                    emit(getHeroesDB())
                }
            }.catch {
                emit(Either.Left(Failure.CustomError(it.stackTrace.hashCode(), it.localizedMessage)))
            }.flowOn(Dispatchers.IO)

        }

        private fun getHeroesApi(): Either<Failure, List<HeroEntity>> {
            return when (networkHandler.isConnected) {
                true -> request(service.getHeros(), {
                    saveInDb(it)
                    it.heroNetworks.map { heroNetwork -> heroNetwork.toHeroEntity() }
                }, ResultApi.empty())
                false -> Either.Left(Failure.NetworkConnection())
            }
        }

        private fun getHeroesDB(): Either<Failure, List<HeroEntity>> {
            return try {
                Either.Right(heroesDB.getHeroes())
            }catch (e: Exception) {
                Either.Left(Failure.CustomError(ServiceKOs.DATABASE_ACCESS_ERROR, e.message))
            }
        }

        private fun saveInDb(apiResult: ResultApi) {
            shared["version"] = apiResult.meta.apiVersion
            shared["time"] = Date().time

            val heroesEntity = apiResult.heroNetworks.map { it.toHeroEntity() }

            heroesDB.addHeroes(heroesEntity)
        }

        private fun isFetchCurrentNeeded(lastFetchTime: Long): Boolean {
            val oneMinuteInMillis = 60000
            val oneDayAgo = Date(lastFetchTime - (1440 * oneMinuteInMillis)).time
            return Date(lastFetchTime).before(Date(oneDayAgo))
        }

    }
}