package com.deneb.epicsevenappdb.features.heroes

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.deneb.epicsevenappdb.core.functional.map
import com.deneb.epicsevenappdb.core.platform.BaseViewModel
import com.deneb.epicsevenappdb.features.heroes.model.HeroEntity
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

    private var heroesFull: List<HeroEntity> = listOf()

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
            .map { either ->
                either.map {
                    it.filter { hero ->
                        !hero.name.contains("MISSING")
                    }
                }
            }
            .collect {
                it.fold(::handleFailure, ::handleHeroes)
            }
    }

    private fun handleHeroes(heroes: List<HeroEntity>) {
        heroes.sortedBy { it.name }
        _heroes.value = heroes
        heroesFull = heroes
    }


    fun filterTypeAndClass(
        listType: MutableList<String>,
        listClass: MutableList<String>,
        listStars: MutableList<Int>) {

        var heroesAux: MutableList<HeroEntity> = mutableListOf()
        val heroesFilteredClass: MutableList<HeroEntity> = mutableListOf()
        val heroesFilteredStar: MutableList<HeroEntity> = mutableListOf()

        listType.forEach { text ->
            heroesFull.forEach {
                if (it.attribute.contentEquals(text)){
                    heroesAux.add(it)
                }
            }
        }

        listClass.forEach {text ->
            if (heroesAux.isEmpty()) {
                heroesFull.forEach {
                    if (it.role.contentEquals(text)){
                        heroesFilteredClass.add(it)
                    }
                }
            } else {
                heroesAux.forEach {
                    if (it.role.contentEquals(text)){
                        heroesFilteredClass.add(it)
                    }
                }
            }
        }

        if (heroesFilteredClass.isNotEmpty())
            heroesAux = heroesFilteredClass

        listStars.forEach {star ->
            if (heroesAux.isNotEmpty()){
                heroesAux.forEach {
                    if (it.rarity == star){
                        heroesFilteredStar.add(it)
                    }
                }
            }else {
                heroesFull.forEach {
                    if (it.rarity == star){
                        heroesFilteredStar.add(it)
                    }
                }
            }

        }

        if (heroesFilteredStar.isNotEmpty())
            heroesAux = heroesFilteredStar

        heroesAux.sortBy {
            it.name
        }
        if (heroesAux.isEmpty()){
            _heroes.value = heroesFull
        }else{
            _heroes.value = heroesAux
        }

    }
}