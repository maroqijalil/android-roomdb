package my.maroqi.application.moviecatalogue.data

import android.content.Context
import androidx.lifecycle.LiveData
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.data.source.local.db.DataRoomDatabase
import my.maroqi.application.moviecatalogue.data.source.local.db.MovieItemDao
import my.maroqi.application.moviecatalogue.data.source.local.db.TVItemDao

class FavouriteRepository (private val context: Context) {

    private val movieDao: MovieItemDao
    private val tvDao: TVItemDao

    init {
        val db = DataRoomDatabase.getDatabase(context)
        movieDao = db.movieDao()
        tvDao = db.tvDao()
    }

    suspend fun getAllMovie(): ArrayList<MovieItem> = movieDao.getAll()
    suspend fun getAllTV(): ArrayList<TVItem> = tvDao.getAll()

    fun getMovieLiveData(): LiveData<ArrayList<MovieItem>> = movieDao.getLiveData()
    fun getTVLiveData(): LiveData<ArrayList<TVItem>> = tvDao.getLiveData()

    suspend fun insertMovie(movie: MovieItem) {
        movieDao.insert(movie)
    }

    suspend fun deleteMovie(movie: MovieItem) {
        movieDao.delete(movie)
    }

    suspend fun insertTV(tv: TVItem) {
        tvDao.insert(tv)
    }

    suspend fun deleteTV(tv: TVItem) {
        tvDao.delete(tv)
    }
}