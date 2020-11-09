package my.maroqi.application.moviecatalogue.ui.main.list

import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import my.maroqi.application.moviecatalogue.data.MovieRepository
import my.maroqi.application.moviecatalogue.data.TVRepository
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.utility.launchIdling

class CatalogueListViewModel(svd: SavedStateHandle) : ViewModel() {

    val savedState = svd

    private val dataList = MutableLiveData<ArrayList<*>>()
    private var _dataList: ArrayList<*>? = null

    private lateinit var type: ListItemType
    private var vmCoroutineScope = CoroutineScope(Job() + Dispatchers.IO)

    private val movieRepository = MovieRepository()
    private val tvRepository = TVRepository()

    companion object {
        const val MOVIE_SVD = "movie_list_svd"
        const val TV_SVD = "tv_list_svd"
    }

    fun setType(type: ListItemType) {
        this.type = type

        if (this.type == ListItemType.MOVIE)
            getMovieListData()
        else if (this.type == ListItemType.TV_SHOW)
            getTVListData()
    }

    fun getDataList(): LiveData<ArrayList<*>> {
        return dataList
    }

    private fun getMovieListData() {
        vmCoroutineScope.launchIdling {
            val movieListData = movieRepository.getListData()

            dataList.postValue(movieListData)
            _dataList = movieListData
            saveDataList()
        }
    }

    private fun getTVListData() {
        vmCoroutineScope.launchIdling {
            val tvListData = tvRepository.getListData()

            dataList.postValue(tvListData)
            _dataList = tvListData
            saveDataList()
        }
    }

    private fun saveDataList() {
        if (type == ListItemType.MOVIE) {
            if (savedState.contains(MOVIE_SVD)) {
                savedState.remove<ArrayList<*>>(MOVIE_SVD)
                savedState.set(MOVIE_SVD, _dataList)
            } else {
                savedState.set(MOVIE_SVD, _dataList)
            }
        } else if (type == ListItemType.TV_SHOW) {
            if (savedState.contains(TV_SVD)) {
                savedState.remove<ArrayList<*>>(TV_SVD)
                savedState.set(TV_SVD, _dataList)
            } else {
                savedState.set(TV_SVD, _dataList)
            }
        }
    }

    fun loadDataList(): ArrayList<*>? {
        return if (type == ListItemType.MOVIE) {
            savedState.get<ArrayList<*>>(MOVIE_SVD)
        } else {
            savedState.get<ArrayList<*>>(TV_SVD)
        }
    }
}