package my.maroqi.application.moviecatalogue.data.source.local.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.model.TVItem
import java.util.concurrent.Executors

@Database(entities = [MovieItem::class, TVItem::class], version = 2)
abstract class DataRoomDatabase: RoomDatabase() {

    abstract fun movieDao(): MovieItemDao
    abstract fun tvDao(): TVItemDao

    companion object {
        @Volatile
        private var INSTANCE: DataRoomDatabase? = null

        @JvmStatic
        fun getDatabase(context: Context): DataRoomDatabase {
            if (INSTANCE == null) {
                synchronized(DataRoomDatabase::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Room.databaseBuilder(context.applicationContext,
                            DataRoomDatabase::class.java, "data_database")
                            .setTransactionExecutor(Executors.newSingleThreadExecutor())
                            .build()
                    }
                }
            }

            return INSTANCE as DataRoomDatabase
        }
    }
}