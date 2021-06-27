package com.deneb.epicsevenappdb.features.heroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deneb.epicsevenappdb.R
import com.deneb.epicsevenappdb.core.exception.Failure
import com.deneb.epicsevenappdb.core.extensions.failure
import com.deneb.epicsevenappdb.core.extensions.observe
import com.deneb.epicsevenappdb.core.extensions.onClick
import com.deneb.epicsevenappdb.core.platform.BaseFragment
import com.deneb.epicsevenappdb.databinding.FragmentHeroesBinding
import com.deneb.epicsevenappdb.features.heroes.model.HeroEntity
import kotlinx.android.synthetic.main.fragment_heroes.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


@ExperimentalCoroutinesApi
class HeroesFragment : BaseFragment<FragmentHeroesBinding>() {

    private val getHeroesViewModel: GetHeroesViewModel by sharedViewModel()
    private val filterViewModel: FilterViewModel by sharedViewModel()
    private val heroesAdapter: HeroesAdapter by inject()

    //TODO: Cambiar por clase para fab
    private val rotateOpen: Animation by lazy {
        AnimationUtils.loadAnimation(
            this.requireContext(),
            R.anim.rotation_open_anim
        )
    }
    private val rotateClose: Animation by lazy {
        AnimationUtils.loadAnimation(
            this.requireContext(),
            R.anim.rotation_close_anim
        )
    }
    private val fromBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            this.requireContext(),
            R.anim.from_bottom_anim
        )
    }
    private val toBottom: Animation by lazy {
        AnimationUtils.loadAnimation(
            this.requireContext(),
            R.anim.to_bottom_anim
        )
    }

    private var clicked = false

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

        binding?.floating?.onClick {
            onFABClicked()
        }

        binding?.filterFAB?.setOnClickListener {
            BottomSheetFilter(this.requireActivity())
                .create("Filter") { listTypes, listClasses, listStars ->
                    getHeroesViewModel.filterTypeAndClass(listTypes, listClasses, listStars)
                }
            onFABClicked()
        }

        binding?.searchFAB?.setOnClickListener {
            onFABClicked()
        }

        binding?.heroesList?.addOnScrollListener(object : RecyclerView.OnScrollListener() {
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                if (dy > 0 || dy < 0 && floating.isShown) {
                    floating.hide()
                }
            }

            override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
                if (newState == RecyclerView.SCROLL_STATE_IDLE) {
                    floating.show()
                }
                super.onScrollStateChanged(recyclerView, newState)
            }
        })
    }

    private fun onFABClicked() {
        setVisibility(clicked)
        setAnimation(clicked)
        clicked = !clicked
    }

    private fun setAnimation(clicked: Boolean) {
        if (!clicked) {
            binding?.filterFAB?.startAnimation(fromBottom)
            binding?.searchFAB?.startAnimation(fromBottom)
            binding?.floating?.startAnimation(rotateOpen)
        } else {
            binding?.filterFAB?.startAnimation(toBottom)
            binding?.searchFAB?.startAnimation(toBottom)
            binding?.floating?.startAnimation(rotateClose)
        }
    }

    private fun setVisibility(clicked: Boolean) {
        if (!clicked) {
            binding?.filterFAB?.visibility = View.VISIBLE
            binding?.searchFAB?.visibility = View.VISIBLE
        } else {
            binding?.filterFAB?.visibility = View.GONE
            binding?.searchFAB?.visibility = View.GONE
        }
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