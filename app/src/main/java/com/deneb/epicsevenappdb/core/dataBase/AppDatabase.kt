package com.deneb.epicsevenappdb.core.dataBase

import androidx.room.Database
import androidx.room.RoomDatabase
import com.deneb.epicsevenappdb.core.dao.HeroDAO
import com.deneb.epicsevenappdb.features.heroes.model.HeroEntity

@Database(entities = [HeroEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {

    abstract fun heroEntityDao(): HeroDAO

}