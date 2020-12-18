package my.maroqi.application.moviecatalogue.ui.detail

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import my.maroqi.application.moviecatalogue.data.source.local.MovieData
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.source.local.TVData
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.ui.data.DataLists
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.utility.getOrAwaitValue
import org.junit.Before
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.mockito.Mock
import org.mockito.MockitoAnnotations

class DataDetailsViewModelTest {

    @get: Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var dataDetailsViewModel: DataDetailsViewModel

    @Mock
    private lateinit var handle: SavedStateHandle

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        dataDetailsViewModel = DataDetailsViewModel(handle)
    }

    @Test
    fun testTVDetail() {
        val tvDetail = DataLists.getTVDetail(2)
        val type = ListItemType.TV_SHOW

        handle = SavedStateHandle()
        dataDetailsViewModel = DataDetailsViewModel(handle)
        dataDetailsViewModel.setData(type, tvDetail)

        assertEquals(dataDetailsViewModel.getTVDetail().getOrAwaitValue(), tvDetail)
    }

    @Test
    fun testMovieDetail() {
        val movieList = DataLists.getMovieDetail(4)
        val type = ListItemType.MOVIE

        handle = SavedStateHandle()
        dataDetailsViewModel = DataDetailsViewModel(handle)
        dataDetailsViewModel.setData(type, movieList)

        assertEquals(dataDetailsViewModel.getMovieDetail().getOrAwaitValue(), movieList)
    }

    @Test
    fun testZeroData() {
        val zeroList = arrayListOf<Any>()

        handle = SavedStateHandle()
        dataDetailsViewModel = DataDetailsViewModel(handle)

        try {
            assertEquals(dataDetailsViewModel.getTVDetail().getOrAwaitValue(), zeroList)
            assertEquals(dataDetailsViewModel.getMovieDetail().getOrAwaitValue(), zeroList)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}