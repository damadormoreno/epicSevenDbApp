package com.deneb.epicsevenappdb.core.dao

import androidx.room.Dao
import androidx.room.Query
import com.deneb.epicsevenappdb.core.platform.BaseDao
import com.deneb.epicsevenappdb.features.heroes.model.HeroEntity

@Dao
interface HeroDAO: BaseDao<HeroEntity> {

    @Query("SELECT * FROM HeroEntity WHERE id == :heroId")
    fun getHeroById(heroId: String): List<HeroEntity>

    @Query("SELECT * FROM HeroEntity")
    fun getAllHeroes(): List<HeroEntity>

    @Query("DELETE FROM HeroEntity")
    fun deleteAllHeroes()

}