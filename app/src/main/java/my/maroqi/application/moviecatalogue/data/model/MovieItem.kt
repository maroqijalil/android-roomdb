package my.maroqi.application.moviecatalogue.data.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.android.parcel.Parcelize

@Entity(tableName = "movie_item")
@Parcelize
data class MovieItem (
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    var title: String? = null,
    var year: Int = 0,
    var poster: Int = 0,
    var releaseDate: String? = null,
    var country: String? = null,
    var genre: ArrayList<String>? = null,
    var duration: String? = null,
    var desc: String? = null,
    var teams: Map<String, String>? = null,
    var rating: Int = 0,
    var actors: ArrayList<String>? = null
): Parcelable