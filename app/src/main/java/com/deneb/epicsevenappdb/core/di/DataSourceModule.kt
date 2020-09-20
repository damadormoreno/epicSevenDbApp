package com.deneb.epicsevenappdb.core.di

import com.deneb.epicsevenappdb.features.heroes.HeroesService
import org.koin.dsl.module

val dataSourceModule = module {
    factory { HeroesService(get()) }
}