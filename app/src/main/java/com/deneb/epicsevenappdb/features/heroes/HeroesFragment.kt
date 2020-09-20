package com.deneb.epicsevenappdb.features.heroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.deneb.epicsevenappdb.core.exception.Failure
import com.deneb.epicsevenappdb.core.extensions.failure
import com.deneb.epicsevenappdb.core.extensions.observe
import com.deneb.epicsevenappdb.core.extensions.onClick
import com.deneb.epicsevenappdb.core.platform.BaseFragment
import com.deneb.epicsevenappdb.databinding.FragmentHeroesBinding
import com.deneb.epicsevenappdb.features.heroes.model.HeroEntity
import com.deneb.epicsevenappdb.features.heroes.model.HeroNetwork
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

@ExperimentalCoroutinesApi
class HeroesFragment : BaseFragment<FragmentHeroesBinding>() {

    private val getHeroesViewModel: GetHeroesViewModel by sharedViewModel()
    private val heroesAdapter: HeroesAdapter by inject()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(getHeroesViewModel) {
            observe(heroes, ::renderHeroes)
            observe(loading, ::showLoading)
            failure(failure, ::handleFailure)
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        initListeners()
    }

    private fun initializeView() {
        binding?.heroesList?.layoutManager = LinearLayoutManager(activity)
        binding?.heroesList?.adapter = heroesAdapter
    }

    private fun initListeners() {
        heroesAdapter.clickListener = { hero ->

        }

        binding?.floating?.onClick { getHeroesViewModel.showOnlyMoonlights() }
    }

    override fun setBinding(
        inflater: LayoutInflater,
        container: ViewGroup?
    ): FragmentHeroesBinding {
        return FragmentHeroesBinding.inflate(inflater, container, false)
    }

    private suspend fun loadHeroes() {
        getHeroesViewModel.getHeroes()
    }

    private fun renderHeroes(heroes: List<HeroEntity>?) {
        heroesAdapter.collection = heroes.orEmpty()
    }

    private fun showLoading(show: Boolean?) {
        when (show) {
            true -> showProgress()
            false -> hideProgress()
        }
    }

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.CustomError -> TODO()
            is Failure.NetworkConnection -> TODO()
            is Failure.ServerError -> TODO()
            else -> TODO()
        }
    }

}