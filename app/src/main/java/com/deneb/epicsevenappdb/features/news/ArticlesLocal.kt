package com.deneb.epicsevenappdb.features.news

import com.deneb.epicsevenappdb.core.dataBase.AppDatabase
import com.deneb.epicsevenappdb.core.platform.ContextHandler

class ArticlesLocal
(contextHandler: ContextHandler, appDatabase: AppDatabase): ArticlesDBLocal{

    private val articlesApi by lazy {
        appDatabase.articleEntityDao()
    }

    override fun getArticles(): List<ArticleEntity> = articlesApi.getArticles()
    override fun addArticle(articleEntity: ArticleEntity) = articlesApi.insertArticle(articleEntity)

}