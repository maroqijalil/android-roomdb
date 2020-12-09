package my.maroqi.application.moviecatalogue.data.source.local.db

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import my.maroqi.application.moviecatalogue.data.model.TVItem

@Dao
interface TVItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(tv: TVItem)

    @Delete
    suspend fun delete(tv: TVItem)

    @Query("SELECT * from tv_item ORDER BY title ASC")
    suspend fun getAll(): ArrayList<TVItem>

    @Query("SELECT * from tv_item ORDER BY title ASC")
    fun getLiveData(): LiveData<ArrayList<TVItem>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(list: List<TVItem>)
}