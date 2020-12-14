package my.maroqi.application.moviecatalogue.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverter
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "tv_item")
@Parcelize
data class TVItem (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var title: String? = null,
    var year: Int = 0,
    var poster: Int = 0,
    var releaseDate: String? = null,
    var genre: String? = null,
    var duration: String? = null,
    var desc: String? = null,
    var teams: String? = null,
    var rating: Int = 0,
    var actors: String? = null
): Parcelable