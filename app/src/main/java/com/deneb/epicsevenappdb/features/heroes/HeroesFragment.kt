package com.deneb.epicsevenappdb.features.heroes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.Text
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumnFor
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.CircularProgressIndicator
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.deneb.epicsevenappdb.R
import com.deneb.epicsevenappdb.core.exception.Failure
import com.deneb.epicsevenappdb.core.extensions.failure
import com.deneb.epicsevenappdb.core.extensions.observe
import com.deneb.epicsevenappdb.features.heroes.model.ResultHeroListApi
import dev.chrisbanes.accompanist.coil.CoilImageWithCrossfade
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.launch
import org.koin.android.ext.android.inject

@ExperimentalCoroutinesApi
class HeroesFragment : Fragment() {

    private val getHeroesViewModel: GetHeroesViewModel by inject()
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
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return ComposeView(requireContext()).apply {
            setContent {
                Surface(color = MaterialTheme.colors.background) {
                    HeroCard()
                }
            }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //initializeView()
        //initListeners()
        uiScope.launch { loadHeroes() }
    }

    @Composable
    fun HeroCard() {
        val heroes by getHeroesViewModel.heroes.observeAsState()
        if (heroes.isNullOrEmpty()) {
            Stack(modifier = Modifier.fillMaxSize()) {
                CircularProgressIndicator(
                    modifier = Modifier.gravity(Alignment.Center)
                )
            }
        } else {
            CardListItem(items = heroes!!) {
                Column() {
                    ListTitle(hero = it, CircleShape = CircleShape)
                }
            }
        }
    }

    @Composable
    private fun ListTitle(
        hero: ResultHeroListApi.HeroResultSoft,
        CircleShape: RoundedCornerShape,
    ) {
        Row(verticalGravity = Alignment.CenterVertically) {
            CoilImageWithCrossfade(
                data = hero.assets.icon,
                contentScale = ContentScale.Fit,
                modifier = Modifier.padding(12.dp)
                    .preferredHeight(48.dp)
                    .preferredWidth(48.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.preferredWidth(4.dp))
            Text(
                text = hero.name,
                style = TextStyle(
                    color = Color.Blue,
                    fontSize = 18.sp
                )
            )

        }
    }

    @Composable
    fun <T> CardListItem(
        items: List<T>,
        listItems: @Composable (T) -> Unit
    ) {
        LazyColumnFor(
            items = items,
            modifier = Modifier.padding(4.dp).fillMaxSize()
        ) {
            Card(modifier = Modifier.fillMaxWidth().padding(12.dp)) {
                listItems(it)
            }
        }
    }


    private fun initializeView() {
        val heroesList = view?.findViewById<RecyclerView>(R.id.heroesList)
        heroesList?.layoutManager = LinearLayoutManager(activity)
        heroesList?.adapter = heroesAdapter
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

}