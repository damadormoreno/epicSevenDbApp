package com.deneb.epicsevenappdb.core.di

import com.deneb.epicsevenappdb.features.news.GetArticles
import com.deneb.epicsevenappdb.features.news.GetArticlesFlow
import kotlinx.coroutines.Dispatchers
import org.koin.dsl.module

val useCaseModule = module {
    factory { GetArticles(get()) }
    factory { GetArticlesFlow(get(), Dispatchers.Default) }
}