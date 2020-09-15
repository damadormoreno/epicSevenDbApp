package com.deneb.epicsevenappdb.features.heroes

import androidx.lifecycle.MutableLiveData
import com.deneb.epicsevenappdb.core.functional.map
import com.deneb.epicsevenappdb.core.platform.BaseViewModel
import com.deneb.epicsevenappdb.features.heroes.model.ResultHeroListApi.HeroResultSoft
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart

class GetHeroesViewModel(
    private val getHeroes: GetHeroes
): BaseViewModel() {

    var heroes: MutableLiveData<List<HeroResultSoft>> = MutableLiveData()
    var loading: MutableLiveData<Boolean> = MutableLiveData()

    @ExperimentalCoroutinesApi
    suspend fun getHeroes() {
        getHeroes.invoke(Any())
            .onStart { loading.value = true }
            .onEach { loading.value = false }
            .map { either ->
                either.map {
                    it.results
                }
            }
            .collect {
                it.fold(::handleFailure, ::handleHeroes)
            }
    }

    private fun handleHeroes(heroes: List<HeroResultSoft>) {
        this.heroes.value = heroes
    }
}