package com.deneb.epicsevenappdb.features.news

import android.content.SharedPreferences
import com.deneb.epicsevenappdb.UnitTest
import com.deneb.epicsevenappdb.core.exception.Failure
import com.deneb.epicsevenappdb.core.functional.Either
import com.deneb.epicsevenappdb.core.platform.NetworkHandler
import com.nhaarman.mockito_kotlin.given
import com.nhaarman.mockito_kotlin.verify
import com.nhaarman.mockito_kotlin.verifyZeroInteractions
import io.kotlintest.matchers.shouldEqual
import org.amshove.kluent.shouldBeInstanceOf
import org.junit.Before
import org.junit.Test
import org.mockito.Mock
import org.mockito.Mockito
import retrofit2.Call
import retrofit2.Response

class ArticlesRepositoryTest: UnitTest() {

    private lateinit var networkRepository: ArticlesRepository.Network
    @Mock private lateinit var networkHandler: NetworkHandler
    @Mock private lateinit var service: ArticlesService

    @Mock private lateinit var articlesCall: Call<NewsEntity>
    @Mock private lateinit var articlesResponse: Response<NewsEntity>

    @Mock private lateinit var fetchLocal: FetchLocal
    @Mock private lateinit var local: ArticlesLocal
    private var sharedPreferences: SharedPreferences = Mockito.mock(SharedPreferences::class.java)

    @Before
    fun setUp(){
        networkRepository = ArticlesRepository.Network(networkHandler, service, local, fetchLocal, sharedPreferences)
    }

    @Test fun `should return empty list by default`() {
        given { networkHandler.isConnected }.willReturn(true)
        given { articlesResponse.body() }.willReturn(null)
        given { articlesResponse.isSuccessful }.willReturn(true)
        given { articlesCall.execute() }.willReturn(articlesResponse)
        given { service.getArticles() }.willReturn(articlesCall)

        val articles = networkRepository.getArticles()

        articles shouldEqual Either.Right(emptyList<Article>())
        verify(service).getArticles()
    }

    @Test fun `should get article list from service`() {
        given { networkHandler.isConnected }.willReturn(true)
        given { articlesResponse.body() }.willReturn(
            NewsEntity(
                listOf(
                 ArticleEntity(
                    0,
                    "David",
                    "contenido",
                    "descripcion",
                    "27/03/2019",
                    "titulo1",
                    "https://www.google.es",
                    "https://www.google.es"
                    )
                ),
                "",
                1)
        )
        given { articlesResponse.isSuccessful }.willReturn(true)
        given { articlesCall.execute() }.willReturn(articlesResponse)
        given { service.getArticles() }.willReturn(articlesCall)

        val articles = networkRepository.getArticles()

        articles shouldEqual Either.Right(listOf(
            Article(
                0,
                "David",
                "contenido",
                "descripcion",
                "27/03/2019",
                "titulo1",
                "https://www.google.es",
                "https://www.google.es"
            )))
        verify(service).getArticles()
    }

    @Test
    fun `articles service should return network failure when no connection`() {
        given { networkHandler.isConnected }.willReturn(false)

        val movies = networkRepository.getArticles()

        movies shouldBeInstanceOf Either::class.java
        movies.isLeft shouldEqual true
        movies.fold({ failure -> failure shouldBeInstanceOf Failure.NetworkConnection::class.java }, {})
        verifyZeroInteractions(service)
    }

    @Test
    fun `articles service should return network failure when undefined connection`() {
        given { networkHandler.isConnected }.willReturn(null)

        val movies = networkRepository.getArticles()

        movies shouldBeInstanceOf Either::class.java
        movies.isLeft shouldEqual true
        movies.fold({ failure -> failure shouldBeInstanceOf Failure.NetworkConnection::class.java }, {})
        verifyZeroInteractions(service)
    }

    @Test
    fun `articles service should return server error if no successful response`() {
        given { networkHandler.isConnected }.willReturn(true)

        val movies = networkRepository.getArticles()

        movies shouldBeInstanceOf Either::class.java
        movies.isLeft shouldEqual true
        movies.fold({ failure -> failure shouldBeInstanceOf Failure.ServerError::class.java }, {})
    }
}