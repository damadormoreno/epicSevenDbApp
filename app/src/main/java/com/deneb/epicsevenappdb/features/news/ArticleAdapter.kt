package com.deneb.epicsevenappdb.features.news

import androidx.recyclerview.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.deneb.epicsevenappdb.R
import com.deneb.epicsevenappdb.core.extensions.inflate
import com.deneb.epicsevenappdb.core.extensions.loadFromUrl
import kotlin.properties.Delegates

class ArticleAdapter
: RecyclerView.Adapter<ArticleAdapter.ViewHolder>(){
    internal var collection: List<ArticleView> by Delegates.observable(emptyList()) {
            _, _, _ -> notifyDataSetChanged()
    }

    internal var clickListener: (ArticleView) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_article_row))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collection[position], clickListener)
    }

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(articleView: ArticleView, clickListener: (ArticleView) -> Unit) {
            /*itemView.tvTitleArticle.text = articleView.title
            itemView.tvDescriptionArticle.text = articleView.description
            itemView.imgArticle.loadFromUrl(articleView.urlToImage)
            itemView.setOnClickListener { clickListener(articleView) }*/
        }
    }
}