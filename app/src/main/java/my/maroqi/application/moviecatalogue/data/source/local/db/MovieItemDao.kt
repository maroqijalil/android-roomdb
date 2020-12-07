package my.maroqi.application.moviecatalogue.data.source.local.db

import androidx.paging.DataSource
import androidx.room.*
import my.maroqi.application.moviecatalogue.data.model.MovieItem

@Dao
interface MovieItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(movie: MovieItem)

    @Update
    fun update(movie: MovieItem)

    @Delete
    fun delete(movie: MovieItem)

    @Query("SELECT * from movie_item ORDER BY id ASC")
    fun getAll(): DataSource.Factory<Int, MovieItem>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(list: List<MovieItem>)
}