package com.deneb.epicsevenappdb.features.news

import com.deneb.epicsevenappdb.core.dataBase.AppDatabase
import com.deneb.epicsevenappdb.core.platform.ContextHandler


class FetchLocal
(contextHandler: ContextHandler, appDatabase: AppDatabase): FetchDbLocal {

    private val fetchDb by lazy {
        appDatabase.fetchEntityDao()
    }

    override fun getFetchDate(id: Int): FetchEntity = fetchDb.getFetchDataById(id)
    override fun addFetchDate(fetchEntity: FetchEntity) = fetchDb.insertFetchDate(fetchEntity)
}