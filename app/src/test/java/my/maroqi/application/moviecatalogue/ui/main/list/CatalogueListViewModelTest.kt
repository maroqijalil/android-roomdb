@file:Suppress("UNCHECKED_CAST")

package my.maroqi.application.moviecatalogue.ui.main.list

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import my.maroqi.application.moviecatalogue.data.source.local.MovieData
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.source.local.TVData
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.utility.getOrAwaitValue
import org.junit.Before
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.*

class CatalogueListViewModelTest {

    @get: Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var catalogueListViewModel: CatalogueListViewModel

    @Mock
    private lateinit var handle: SavedStateHandle

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        catalogueListViewModel = CatalogueListViewModel(handle)
    }

    @Test
    fun testTVList() {
        val tvList = getTVListData()
        val type = ListItemType.TV_SHOW

        handle = SavedStateHandle()
        catalogueListViewModel = CatalogueListViewModel(handle)
        catalogueListViewModel.setType(type)

        assertEquals(catalogueListViewModel.getDataList().getOrAwaitValue(), tvList)
    }

    @Test
    fun testMovieList() {
        val movieList = getMovieListData()
        val type = ListItemType.MOVIE

        handle = SavedStateHandle()
        catalogueListViewModel = CatalogueListViewModel(handle)
        catalogueListViewModel.setType(type)

        assertEquals(catalogueListViewModel.getDataList().getOrAwaitValue(), movieList)
    }

    @Test
    fun testZeroList() {
        val zeroList = arrayListOf<Any>()

        handle = SavedStateHandle()
        catalogueListViewModel = CatalogueListViewModel(handle)

        try {
            assertEquals(catalogueListViewModel.getDataList().getOrAwaitValue(), zeroList)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }

    private fun getMovieListData(): ArrayList<MovieItem> {
        val movieListData: ArrayList<MovieItem> = arrayListOf()

        val titles = MovieData.titles
        val years = MovieData.years
        val releaseDate = MovieData.releaseDate
        val countries = MovieData.country
        val genres = MovieData.genres
        val durations = MovieData.duration
        val rating = MovieData.userScore
        val descs = MovieData.shortDesc
        val teams = MovieData.teams
        val actors = MovieData.actors

        titles.forEachIndexed { i, _ ->
            val movieItem = MovieItem(
                title = titles[i],
                year = years[i],
                poster = i,
                releaseDate = releaseDate[i],
                country = countries[i],
                genre = genres[i],
                duration = durations[i],
                rating = rating[i],
                desc = descs[i],
                teams = teams[i],
                actors = actors[i]
            )

            movieListData.add(movieItem)
        }

        return movieListData
    }

    private fun getTVListData(): ArrayList<TVItem> {
        val tvListData: ArrayList<TVItem> = arrayListOf()

        val titles = TVData.titles
        val years = TVData.years
        val releaseDate = TVData.releaseDate
        val genres = TVData.genres
        val durations = TVData.duration
        val rating = TVData.userScore
        val descs = TVData.shortDesc
        val teams = TVData.teams
        val actors = TVData.actors

        titles.forEachIndexed { i, _ ->
            val tvItem = TVItem(
                title = titles[i],
                year = years[i],
                poster = i,
                releaseDate = releaseDate[i],
                genre = genres[i],
                duration = durations[i],
                rating = rating[i],
                desc = descs[i],
                teams = teams[i],
                actors = actors[i]
            )

            tvListData.add(tvItem)
        }

        return tvListData
    }
}