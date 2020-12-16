package my.maroqi.application.moviecatalogue.data

import android.content.Context
import androidx.lifecycle.LiveData
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.data.source.local.db.DataRoomDatabase
import my.maroqi.application.moviecatalogue.data.source.local.db.MovieItemDao
import my.maroqi.application.moviecatalogue.data.source.local.db.TVItemDao
import java.util.concurrent.ExecutorService
import java.util.concurrent.Executors

class FavouriteRepository (private val context: Context) {

    private val movieDao: MovieItemDao
    private val tvDao: TVItemDao

    private val executorService: ExecutorService = Executors.newSingleThreadExecutor()

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
        executorService.execute { movieDao.insert(movie) }
    }

    fun deleteMovie(movie: MovieItem) {
        executorService.execute { movieDao.delete(movie) }
    }

    fun insertTV(tv: TVItem) {
        executorService.execute { tvDao.insert(tv) }
    }

    fun deleteTV(tv: TVItem) {
        executorService.execute { tvDao.delete(tv) }
    }
}