package com.deneb.epicsevenappdb.core.di

import com.deneb.epicsevenappdb.features.news.ArticlesService
import org.koin.dsl.module

val dataSourceModule = module {
    factory { ArticlesService(get()) }
}