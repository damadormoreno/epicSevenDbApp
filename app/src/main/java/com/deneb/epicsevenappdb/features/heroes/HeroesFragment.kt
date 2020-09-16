package com.deneb.epicsevenappdb.features.heroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deneb.epicsevenappdb.R
import com.deneb.epicsevenappdb.core.exception.Failure
import com.deneb.epicsevenappdb.core.extensions.failure
import com.deneb.epicsevenappdb.core.extensions.observe
import com.deneb.epicsevenappdb.core.functional.DialogCallback
import com.deneb.epicsevenappdb.databinding.FragmentHeroesBinding
import com.deneb.epicsevenappdb.features.heroes.model.ResultHeroListApi
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

@ExperimentalCoroutinesApi
class HeroesFragment : Fragment() {

    private var _binding: FragmentHeroesBinding? = null
    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val getHeroesViewModel: GetHeroesViewModel by sharedViewModel()
    private val heroesAdapter: HeroesAdapter by inject()
    private val uiScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        with(getHeroesViewModel) {
            observe(heroes, ::renderHeroes)
            //observe(loading, ::showLoading)
            failure(failure, ::handleFailure)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHeroesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initializeView()
        initListeners()
    }


    private fun initializeView() {
        binding.heroesList.layoutManager = LinearLayoutManager(activity)
        binding.heroesList.adapter = heroesAdapter
    }

    private fun initListeners() {
        heroesAdapter.clickListener = { hero ->

        }
    }

    private suspend fun loadHeroes() {
        getHeroesViewModel.getHeroes()
    }

    private fun renderHeroes(heroes: List<ResultHeroListApi.HeroResultSoft>?) {
        heroesAdapter.collection = heroes.orEmpty()
    }

/*    private fun showLoading(show: Boolean?) {
        when (show) {
            true -> showProgress()
            false -> hideProgress()
        }
    }*/

    private fun handleFailure(failure: Failure?) {
        when (failure) {
            is Failure.CustomError -> TODO()
            is Failure.NetworkConnection -> TODO()
            is Failure.ServerError -> TODO()
            else -> TODO()
        }
    }

/*    private fun renderFailure(errorCode: Int, errorMessage: String?) {
        showError(errorCode, errorMessage, object : DialogCallback {
            override suspend fun onAccept() {
                uiScope.launch { loadHeroes() }
            }

            override suspend fun onDecline() {
                onBackPressed()
            }
        })
    }*/

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}