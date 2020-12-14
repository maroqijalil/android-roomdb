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

    fun getAllMovie(): List<MovieItem> = movieDao.getAll()
    fun getAllTV(): List<TVItem> = tvDao.getAll()

    fun getMovieLiveData(): LiveData<List<MovieItem>> = movieDao.getLiveData()
    fun getTVLiveData(): LiveData<List<TVItem>> = tvDao.getLiveData()

    fun insertMovie(movie: MovieItem) {
        movieDao.insert(movie)
    }

    fun deleteMovie(movie: MovieItem) {
        movieDao.delete(movie)
    }

    fun insertTV(tv: TVItem) {
        tvDao.insert(tv)
    }

    fun deleteTV(tv: TVItem) {
        tvDao.delete(tv)
    }
}