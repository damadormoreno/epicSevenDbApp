package com.deneb.epicsevenappdb.core.di

import com.deneb.epicsevenappdb.features.news.GetArticlesViewModel
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module


val viewModelModule = module {
    viewModel {
        GetArticlesViewModel(get())
    }
    /*scope(named<ArticlesFragment>()){
        viewModel {
            GetArticlesViewModel(get())
        }
    }*/
}
