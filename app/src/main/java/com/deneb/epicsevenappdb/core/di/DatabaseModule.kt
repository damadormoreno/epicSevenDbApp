package com.deneb.epicsevenappdb.core.di

import androidx.room.Room
import com.deneb.epicsevenappdb.core.dataBase.AppDatabase
import com.deneb.epicsevenappdb.features.news.ArticlesLocal
import com.deneb.epicsevenappdb.features.news.FetchLocal
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "newsDB"
        )
            .build()
    }
    factory { FetchLocal(get(), get()) }
    factory { ArticlesLocal(get(), get()) }
}