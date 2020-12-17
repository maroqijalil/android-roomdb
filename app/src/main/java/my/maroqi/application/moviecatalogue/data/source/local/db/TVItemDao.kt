package my.maroqi.application.moviecatalogue.data.source.local.db

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.model.TVItem

@Dao
interface TVItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tv: TVItem)

    @Query("DELETE FROM tv_item WHERE title=:title")
    fun delete(title: String)

    @Query("SELECT * from tv_item")
    fun getAllPaged(): DataSource.Factory<Int, TVItem>

    @Query("SELECT * from tv_item")
    fun getAll(): List<TVItem>

    @Query("SELECT * from tv_item")
    fun getLiveData(): LiveData<List<TVItem>>
}