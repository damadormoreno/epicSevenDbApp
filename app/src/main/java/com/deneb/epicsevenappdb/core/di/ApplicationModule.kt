package com.deneb.epicsevenappdb.core.di

import android.content.Context
import android.content.SharedPreferences
import com.deneb.epicsevenappdb.features.heroes.HeroesAdapter
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.module

val applicationModule = module(override = true) {
    /*scope(named<ArticlesFragment>()){
        factory { ArticleAdapter() }
    }*/
    factory { HeroesAdapter() }
    single<SharedPreferences> { androidContext().getSharedPreferences("SharedPreferences", Context.MODE_PRIVATE) }
}