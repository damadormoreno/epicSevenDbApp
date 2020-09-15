package com.deneb.epicsevenappdb.features.heroes

import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.deneb.epicsevenappdb.R
import com.deneb.epicsevenappdb.core.extensions.inflate
import com.deneb.epicsevenappdb.core.extensions.loadFromUrl
import com.deneb.epicsevenappdb.features.heroes.model.ResultHeroListApi
import kotlin.properties.Delegates

class HeroesAdapter
    : RecyclerView.Adapter<HeroesAdapter.ViewHolder>(){
    internal var collection: List<ResultHeroListApi.HeroResultSoft> by Delegates.observable(emptyList()) {
            _, _, _ -> notifyDataSetChanged()
    }

    internal var clickListener: (ResultHeroListApi.HeroResultSoft) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_article_row))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collection[position], clickListener)
    }

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvTitleArticle = itemView.findViewById<TextView>(R.id.tvTitleArticle)
        val tvDescriptionArticle = itemView.findViewById<TextView>(R.id.tvDescriptionArticle)
        val imgArticle = itemView.findViewById<ImageView>(R.id.imgArticle)
        fun bind(heroe: ResultHeroListApi.HeroResultSoft, clickListener: (ResultHeroListApi.HeroResultSoft) -> Unit) {
            tvTitleArticle.text = heroe.name
            tvDescriptionArticle.text = heroe.role
            imgArticle.loadFromUrl(heroe.assets.thumbnail)
            itemView.setOnClickListener { clickListener(heroe) }
        }
    }
}