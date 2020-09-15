package com.deneb.epicsevenappdb.core.di

import com.deneb.epicsevenappdb.features.heroes.GetHeroesViewModel
import com.deneb.epicsevenappdb.features.news.GetArticlesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


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
