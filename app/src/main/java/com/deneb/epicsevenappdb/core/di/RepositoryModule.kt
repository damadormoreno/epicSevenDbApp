package com.deneb.epicsevenappdb.core.di

import com.deneb.epicsevenappdb.features.news.ArticlesRepository
import org.koin.dsl.module

val repositoryModule = module {
    factory<ArticlesRepository> { ArticlesRepository.Network(get(), get(), get(), get(), get()) }
}