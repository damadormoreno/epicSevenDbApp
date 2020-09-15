package com.deneb.epicsevenappdb.core.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.deneb.epicsevenappdb.core.dao.ArticleDAO
import com.deneb.epicsevenappdb.core.dao.FetchDateDAO
import com.deneb.epicsevenappdb.features.news.ArticleEntity
import com.deneb.epicsevenappdb.features.news.FetchEntity

@Database(entities = [ArticleEntity::class, FetchEntity::class], version = 2)
abstract class AppDatabase: RoomDatabase() {

    abstract fun articleEntityDao(): ArticleDAO
    abstract fun fetchEntityDao(): FetchDateDAO

}