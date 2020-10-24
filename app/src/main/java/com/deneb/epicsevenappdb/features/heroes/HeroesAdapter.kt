package com.deneb.epicsevenappdb.features.heroes

import android.content.Context
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.RecyclerView
import com.deneb.epicsevenappdb.R
import com.deneb.epicsevenappdb.core.extensions.inflate
import com.deneb.epicsevenappdb.core.extensions.loadFromUrl
import com.deneb.epicsevenappdb.databinding.ItemHeroRowBinding
import com.deneb.epicsevenappdb.features.heroes.model.HeroEntity
import com.deneb.epicsevenappdb.features.heroes.model.HeroNetwork
import org.jetbrains.anko.backgroundColor
import kotlin.properties.Delegates

class HeroesAdapter
    : RecyclerView.Adapter<HeroesAdapter.ViewHolder>(){
    internal var collection: List<HeroEntity> by Delegates.observable(emptyList()) {
            _, _, _ -> notifyDataSetChanged()
    }

    internal var clickListener: (HeroEntity) -> Unit = { }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(parent.inflate(R.layout.item_hero_row))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(collection[position], clickListener)
    }

    override fun getItemCount() = collection.size

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        private val binding = ItemHeroRowBinding.bind(itemView)
        val context: Context = binding.constraintItem.context
        fun bind(heroe: HeroEntity, clickListener: (HeroEntity) -> Unit) {
            binding.tvNameHero.text = heroe.name
            binding.imgHero.loadFromUrl(heroe.assets.icon)
            when(heroe.attribute) {
                "wind" -> {
                    binding.constraintItem.backgroundColor = ContextCompat.getColor(context, R.color.wind)
                    binding.imgElement.setImageResource(R.drawable.cm_icon_prowind)
                }
                "light" -> {
                    binding.constraintItem.backgroundColor =
                        ContextCompat.getColor(context, R.color.light)
                    binding.imgElement.setImageResource(R.drawable.cm_icon_prolight)
                }
                "dark" -> {
                    binding.constraintItem.backgroundColor =
                        ContextCompat.getColor(context, R.color.dark)
                    binding.imgElement.setImageResource(R.drawable.cm_icon_prodark)
                }
                "fire" -> {
                    binding.constraintItem.backgroundColor =
                        ContextCompat.getColor(context, R.color.fire)
                    binding.imgElement.setImageResource(R.drawable.cm_icon_profire)
                }
                "ice" -> {
                    binding.constraintItem.backgroundColor =
                        ContextCompat.getColor(context, R.color.ice)
                    binding.imgElement.setImageResource(R.drawable.cm_icon_proice)
                }
            }

            when(heroe.role) {
                "warrior" -> binding.imgRole.setImageResource(R.drawable.cm_icon_role_warrior)
                "knight" -> binding.imgRole.setImageResource(R.drawable.cm_icon_role_knight)
                "mage" -> binding.imgRole.setImageResource(R.drawable.cm_icon_role_mage)
                "assassin" -> binding.imgRole.setImageResource(R.drawable.cm_icon_role_assassin)
                "ranger" -> binding.imgRole.setImageResource(R.drawable.cm_icon_role_ranger)
                "manauser" -> binding.imgRole.setImageResource(R.drawable.cm_icon_role_manauser)
            }

            when(heroe.rarity){
                3 -> binding.tvStars.text = binding.tvStars.context.resources.getString(R.string.three_star)
                4 -> binding.tvStars.text = binding.tvStars.context.resources.getString(R.string.four_star)
                5 -> binding.tvStars.text = binding.tvStars.context.resources.getString(R.string.five_stars)
            }

            when(heroe.rarity){
                3 -> binding.imgStar.setImageResource(R.drawable.ic_tres_estrellas)
                4 -> binding.imgStar.setImageResource(R.drawable.ic_cuatro)
                5 -> binding.imgStar.setImageResource(R.drawable.ic_cinco_estrellas)
            }

            itemView.setOnClickListener { clickListener(heroe)
            }

        }
    }
}