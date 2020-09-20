package com.deneb.epicsevenappdb.core.di

import com.deneb.epicsevenappdb.features.heroes.GetHeroes
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetHeroes(get(), Dispatchers.Default) }
}