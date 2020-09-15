package com.deneb.epicsevenappdb.features.news

interface ArticlesDBLocal {
    fun getArticles(): List<ArticleEntity>
    fun addArticle(articleEntity: ArticleEntity): Any
}