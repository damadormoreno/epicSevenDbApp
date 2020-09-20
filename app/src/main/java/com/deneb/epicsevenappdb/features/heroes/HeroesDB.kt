package com.deneb.epicsevenappdb.features.heroes

import com.deneb.epicsevenappdb.features.heroes.model.HeroEntity

interface HeroesDB {
    fun getHeroes(): List<HeroEntity>
    fun addHero(heroNetwork: HeroEntity): Any
    fun addHeroes(heroes: List<HeroEntity>)
}