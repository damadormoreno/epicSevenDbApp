package com.deneb.epicsevenappdb.features.news


import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.appcompat.widget.SearchView
import android.view.View
import androidx.navigation.findNavController
import com.deneb.epicsevenappdb.R
import com.deneb.epicsevenappdb.core.exception.Failure
import com.deneb.epicsevenappdb.core.extensions.failure
import com.deneb.epicsevenappdb.core.extensions.observe
import com.deneb.epicsevenappdb.core.functional.DialogCallback
import com.deneb.epicsevenappdb.core.platform.BaseFragment
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

@ExperimentalCoroutinesApi
class ArticlesFragment : BaseFragment() {

    override fun layoutId() = R.layout.fragment_articles

    private val articleAdapter: ArticleAdapter by inject()
    private val getArticlesViewModel: GetArticlesViewModel by inject()

    private val uiScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(getArticlesViewModel) {
            observe(articles, ::renderArticlesList)
            observe(loading, ::showLoading)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        initListeners()
        uiScope.launch { loadArticles() }
    }

    private fun initializeView() {

/*        articleList.layoutManager = LinearLayoutManager(activity)
        articleList.adapter = articleAdapter

        searchBarProfiles.onActionViewExpanded()
        searchBarProfiles.isFocusable = false
        searchBarProfiles.clearFocus()
        searchBarProfiles.queryHint = "Buscar"*/

    }

    private fun initListeners() {
        articleAdapter.clickListener = { articleView ->
            val bundle = Bundle()
            bundle.putSerializable("article", articleView)
            view?.findNavController()
                ?.navigate(R.id.action_articlesFragment_to_articleDetailFragment, bundle)
        }

/*        searchBarProfiles.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(s: String): Boolean {
                return false
            }

            override fun onQueryTextChange(s: String): Boolean {
                getArticlesViewModel.filter(s)
                return false
            }
        })*/
    }

    private suspend fun loadArticles() {
        getArticlesViewModel.getArticles()
    }

    private fun renderArticlesList(articles: List<ArticleView>?) {
        articleAdapter.collection = articles.orEmpty()
    }

    private fun showLoading(show: Boolean?) {
        when (show) {
            true -> showProgress()
            false -> hideProgress()
        }


    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.CustomError -> renderFailure(failure.errorCode, failure.errorMessage)
            else -> renderFailure(0, "")
        }
    }

    private fun renderFailure(errorCode: Int, errorMessage: String?) {
        showError(errorCode, errorMessage, object : DialogCallback {
            override suspend fun onAccept() {
                uiScope.launch { loadArticles() }
            }

            override suspend fun onDecline() {
                onBackPressed()
            }
        })
    }

}