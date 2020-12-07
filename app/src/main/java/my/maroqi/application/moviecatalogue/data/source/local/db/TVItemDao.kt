package my.maroqi.application.moviecatalogue.data.source.local.db

import androidx.paging.DataSource
import androidx.room.*
import my.maroqi.application.moviecatalogue.data.model.TVItem

@Dao
interface TVItemDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insert(tv: TVItem)

    @Update
    fun update(tv: TVItem)

    @Delete
    fun delete(tv: TVItem)

    @Query("SELECT * from tv_item ORDER BY id ASC")
    fun getAll(): DataSource.Factory<Int, TVItem>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertAll(list: List<TVItem>)
}