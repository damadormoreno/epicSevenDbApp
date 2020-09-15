package com.deneb.epicsevenappdb

import android.app.Application
import com.deneb.epicsevenappdb.core.di.*
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import org.koin.core.logger.Level

class AndroidApplication: Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger(Level.NONE)
            androidContext(this@AndroidApplication)
            modules(listOf(
                networkModule,
                applicationModule,
                databaseModule,
                dataSourceModule,
                repositoryModule,
                useCaseModule,
                viewModelModule
            ))
        }
    }
}
