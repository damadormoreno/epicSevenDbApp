package com.deneb.epicsevenappdb.features.heros

import com.deneb.epicsevenappdb.features.heros.model.ResultHeroListApi
import retrofit2.Call
import retrofit2.http.GET

internal interface HeroListApi {
    @GET("hero")
    fun getHeros(): Call<ResultHeroListApi>
}