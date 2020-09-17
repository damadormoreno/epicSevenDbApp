package com.deneb.epicsevenappdb.features.favorites

import android.view.LayoutInflater
import android.view.ViewGroup
import com.deneb.epicsevenappdb.R
import com.deneb.epicsevenappdb.core.platform.BaseFragment
import com.deneb.epicsevenappdb.databinding.FragmentFavoritesBinding

class FavoritesFragment : BaseFragment<FragmentFavoritesBinding>() {
    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentFavoritesBinding {
        return FragmentFavoritesBinding.inflate(inflater, container, false)
    }

}
