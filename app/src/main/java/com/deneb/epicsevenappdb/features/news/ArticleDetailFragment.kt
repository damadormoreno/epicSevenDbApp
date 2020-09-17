package com.deneb.epicsevenappdb.features.news


import android.os.Bundle
import android.view.View
import com.deneb.epicsevenappdb.core.extensions.loadFromUrl
import com.deneb.epicsevenappdb.core.platform.BaseFragment
import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import com.deneb.epicsevenappdb.R
import com.deneb.epicsevenappdb.databinding.FragmentArticlesBinding


class ArticleDetailFragment : BaseFragment<FragmentArticlesBinding>() {


    private var article: ArticleView? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arguments = arguments
        if (arguments != null) {
            article = arguments.getSerializable("article") as ArticleView
            initLayout()
            initListener()
        }
    }

    private fun initLayout() {
/*        imageDetail.loadFromUrl(article?.urlToImage?:"")
        titleDetail.text = article?.title
        authorDetail.text = article?.author
        contentDetail.text = article?.content*/
    }

    private fun initListener() {
/*        tvOpenInChrome.setOnClickListener {
            val browserIntent = Intent(Intent.ACTION_VIEW, Uri.parse(article?.url))
            startActivity(browserIntent)
        }*/
    }

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentArticlesBinding {
        return FragmentArticlesBinding.inflate(inflater, container, false)
    }

}
