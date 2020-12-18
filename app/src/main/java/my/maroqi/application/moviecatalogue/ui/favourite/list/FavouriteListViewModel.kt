package my.maroqi.application.moviecatalogue.ui.favourite.list

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import my.maroqi.application.moviecatalogue.data.FavouriteRepository
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.ui.main.list.CatalogueListViewModel
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.utility.MovieResource
import my.maroqi.application.moviecatalogue.utility.TVResource
import my.maroqi.application.moviecatalogue.utility.launchIdling

class FavouriteListViewModel(svd: SavedStateHandle, ctx: Context) : ViewModel() {

    private val context = ctx

    private val dataRepository = FavouriteRepository(context)

    fun getAllMovie(): LiveData<PagedList<MovieItem>> =
        LivePagedListBuilder(dataRepository.getAllMoviePaged(), 5).build()

    fun getAllTV(): LiveData<PagedList<TVItem>> =
        LivePagedListBuilder(dataRepository.getAllTVPaged(), 5).build()
}