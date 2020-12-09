package my.maroqi.application.moviecatalogue.data.source.local.db

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import my.maroqi.application.moviecatalogue.data.model.MovieItem

@Dao
interface MovieItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(movie: MovieItem)

    @Delete
    suspend fun delete(movie: MovieItem)

    @Query("SELECT * from movie_item ORDER BY title ASC")
    suspend fun getAll(): ArrayList<MovieItem>

    @Query("SELECT * from movie_item ORDER BY title ASC")
    fun getLiveData(): LiveData<ArrayList<MovieItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(list: ArrayList<MovieItem>)
}