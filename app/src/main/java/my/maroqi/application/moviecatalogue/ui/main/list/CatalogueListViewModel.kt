package my.maroqi.application.moviecatalogue.ui.main.list

import android.content.Context
import androidx.lifecycle.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import my.maroqi.application.moviecatalogue.data.FavouriteRepository
import my.maroqi.application.moviecatalogue.data.MovieRepository
import my.maroqi.application.moviecatalogue.data.TVRepository
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.utility.MovieResource
import my.maroqi.application.moviecatalogue.utility.TVResource
import my.maroqi.application.moviecatalogue.utility.launchIdling

class CatalogueListViewModel(svd: SavedStateHandle, ctx: Context) : ViewModel() {

    val savedState = svd
    val context = ctx

    private val dataList = MutableLiveData<ArrayList<*>>()
    private var _dataList: ArrayList<*>? = null

    private lateinit var type: ListItemType
    private var vmCoroutineScope = CoroutineScope(Job() + Dispatchers.Default)

    private val movieRepository = MovieRepository()
    private val tvRepository = TVRepository()

    private val dataRepository = FavouriteRepository(context)
    private lateinit var repositoryObserver: Observer<List<*>>

    companion object {
        const val MOVIE_SVD = "movie_list_svd"
        const val TV_SVD = "tv_list_svd"
    }

    fun setType(type: ListItemType) {
        this.type = type

        if (this.type == ListItemType.MOVIE) {
            repositoryObserver = Observer {
                if (it.size > 0) {
                    getMovieListData()
                }
            }
            dataRepository.getMovieLiveData().observeForever(repositoryObserver)
            getMovieListData()
        }
        else if (this.type == ListItemType.TV_SHOW) {
            repositoryObserver = Observer {
                if (it.size > 0) {
                    getTVListData()
                }
            }
            dataRepository.getTVLiveData().observeForever(repositoryObserver)
            getTVListData()
        }
    }

    fun getDataList(): LiveData<ArrayList<*>> {
        return dataList
    }

    private fun getMovieListData() {
        val movieListFav = dataRepository.getAllMovie()
        vmCoroutineScope.launchIdling {
            val movieListData = movieRepository.getListData()
            val resourceList = arrayListOf<MovieResource>()

            movieListData.forEach { it1 ->
                var fav = false
                movieListFav.forEach { it2 ->
                    if (it1.title.equals(it2.title)) {
                        resourceList.add(MovieResource.getFavMovie(it1))
                        fav = true
                    }
                }
                if (!fav)
                    resourceList.add(MovieResource.getMovie(it1))
            }

            dataList.postValue(resourceList)
            _dataList = resourceList
            saveDataList()
        }
    }

    private fun getTVListData() {
        val tvListFav = dataRepository.getAllTV()
        vmCoroutineScope.launchIdling {
            val tvListData = tvRepository.getListData()
            val resourceList = arrayListOf<TVResource>()

            tvListData.forEach { it1 ->
                var fav = false
                tvListFav.forEach { it2 ->
                    if (it1.title.equals(it2.title)) {
                        resourceList.add(TVResource.getFavTV(it1))
                        fav = true
                    }
                }
                if (!fav)
                    resourceList.add(TVResource.getTV(it1))
            }

            dataList.postValue(resourceList)
            _dataList = resourceList
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

    fun insertFavMovie(movie: MovieItem) {
        dataRepository.insertMovie(movie)
    }

    fun deleteFavMovie(movie: MovieItem) {
        dataRepository.deleteMovie(movie)
    }

    fun insertFavTV(tv: TVItem) {
        dataRepository.insertTV(tv)
    }

    fun deleteFavTV(tv: TVItem) {
        dataRepository.deleteTV(tv)
    }
}