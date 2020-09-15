package com.deneb.epicsevenappdb.features.heroes

import com.deneb.epicsevenappdb.features.heroes.model.ResultHeroListApi
import retrofit2.Call
import retrofit2.Retrofit

class HeroesService(retrofit: Retrofit): HeroListApi {

    private val heroesApi by lazy { retrofit.create(HeroListApi::class.java) }

    override fun getHeros(): Call<ResultHeroListApi> = heroesApi.getHeros()

}