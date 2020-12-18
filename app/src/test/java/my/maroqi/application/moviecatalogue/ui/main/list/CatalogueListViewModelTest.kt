@file:Suppress("UNCHECKED_CAST")

package my.maroqi.application.moviecatalogue.ui.main.list

import android.content.Context
import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.SavedStateHandle
import my.maroqi.application.moviecatalogue.ui.data.DataLists
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.utility.getOrAwaitValue
import org.junit.Before
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import org.mockito.*
import org.mockito.Mockito.`when`
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class CatalogueListViewModelTest {

    @get: Rule
    val rule = InstantTaskExecutorRule()

    private lateinit var catalogueListViewModel: CatalogueListViewModel

    @Mock
    private lateinit var handle: SavedStateHandle

    @Mock
    private lateinit var context: Context

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)

        `when`(context.applicationContext).thenReturn(context)
        catalogueListViewModel = CatalogueListViewModel(handle, context)
    }

    @Test
    fun testTVList() {
        val tvList = DataLists.getTVListData()
        val type = ListItemType.TV_SHOW_T

        handle = SavedStateHandle()
        catalogueListViewModel = CatalogueListViewModel(handle, context)
        catalogueListViewModel.setType(type)

        assertEquals(catalogueListViewModel.getDataList().getOrAwaitValue(), tvList)
    }

    @Test
    fun testMovieList() {
        val movieList = DataLists.getMovieListData()
        val type = ListItemType.MOVIE_T

        handle = SavedStateHandle()
        catalogueListViewModel = CatalogueListViewModel(handle, context)
        catalogueListViewModel.setType(type)

        assertEquals(catalogueListViewModel.getDataList().getOrAwaitValue(), movieList)
    }

    @Test
    fun testZeroList() {
        val zeroList = arrayListOf<Any>()

        handle = SavedStateHandle()
        catalogueListViewModel = CatalogueListViewModel(handle, context)

        try {
            assertEquals(catalogueListViewModel.getDataList().getOrAwaitValue(), zeroList)
        } catch (e: Exception) {
            e.printStackTrace()
        }
    }
}