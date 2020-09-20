package com.deneb.epicsevenappdb.features.heroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.deneb.epicsevenappdb.core.functional.map
import com.deneb.epicsevenappdb.core.platform.BaseViewModel
import com.deneb.epicsevenappdb.features.heroes.model.HeroEntity
import com.deneb.epicsevenappdb.features.heroes.model.HeroNetwork
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch

@ExperimentalCoroutinesApi
class GetHeroesViewModel(
    private val getHeroes: GetHeroes
): BaseViewModel() {

    private val _heroes: MutableLiveData<List<HeroEntity>> = MutableLiveData()
    val heroes: LiveData<List<HeroEntity>> = _heroes

    private val _loading: MutableLiveData<Boolean> = MutableLiveData()
    val loading: LiveData<Boolean> = _loading

    init {
        viewModelScope.launch { getHeroes() }
    }

    @ExperimentalCoroutinesApi
    suspend fun getHeroes() {
        getHeroes.invoke(Any())
            .onStart { _loading.value = true }
            .onEach { _loading.value = false }
/*            .map { either ->
                either.map {
                    it
                }
            }*/
            .collect {
                it.fold(::handleFailure, ::handleHeroes)
            }
    }

    private fun handleHeroes(heroes: List<HeroEntity>) {
        _heroes.value = heroes
    }
}