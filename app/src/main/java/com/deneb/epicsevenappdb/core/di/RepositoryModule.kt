package com.deneb.epicsevenappdb.core.di

import com.deneb.epicsevenappdb.features.heroes.HeroesRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<HeroesRepository> { HeroesRepository.HeroesRepositoryImpl(get(), get(), get(), get()) }
}