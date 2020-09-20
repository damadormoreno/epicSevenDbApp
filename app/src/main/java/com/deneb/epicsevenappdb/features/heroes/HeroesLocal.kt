package com.deneb.epicsevenappdb.features.heroes

import com.deneb.epicsevenappdb.core.dataBase.AppDatabase
import com.deneb.epicsevenappdb.features.heroes.model.HeroEntity

class HeroesLocal(appDatabase: AppDatabase): HeroesDB {

    private val heroesDao by lazy {
        appDatabase.heroEntityDao()
    }
    override fun getHeroes(): List<HeroEntity> = heroesDao.getAllHeroes()

    override fun addHero(heroNetwork: HeroEntity): Any = heroesDao.insert(heroNetwork)

    override fun addHeroes(heroes: List<HeroEntity>) = heroesDao.insertAll(heroes)
}