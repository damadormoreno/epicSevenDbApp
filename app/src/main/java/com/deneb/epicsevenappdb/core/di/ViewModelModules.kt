package com.deneb.epicsevenappdb.core.di

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
    /*scope(named<ArticlesFragment>()){
        viewModel {
            GetArticlesViewModel(get())
        }
    }*/
}
