package com.deneb.epicsevenappdb.core.di

import androidx.room.Room
import com.deneb.epicsevenappdb.core.dataBase.AppDatabase
import com.deneb.epicsevenappdb.features.heroes.HeroesLocal
import org.koin.dsl.module

val databaseModule = module {
    single {
        Room.databaseBuilder(
            get(),
            AppDatabase::class.java,
            "epicDB"
        )
            .build()
    }

    factory { HeroesLocal(get()) }
}