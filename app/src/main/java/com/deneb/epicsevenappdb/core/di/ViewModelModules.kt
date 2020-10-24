package com.deneb.epicsevenappdb.core.di

import com.deneb.epicsevenappdb.features.heroes.FilterViewModel
import com.deneb.epicsevenappdb.features.heroes.GetHeroesViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module


@ExperimentalCoroutinesApi
val viewModelModule = module {
    viewModel {
        //GetArticlesViewModel(get())
        GetHeroesViewModel(get())
    }
    viewModel { FilterViewModel() }
    /*scope(named<ArticlesFragment>()){
        viewModel {
            GetArticlesViewModel(get())
        }
    }*/
}
