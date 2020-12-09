package my.maroqi.application.moviecatalogue.utility

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import my.maroqi.application.moviecatalogue.data.model.MovieItem

@Parcelize
data class MovieResource(val favourite: Boolean, val movie: MovieItem): Parcelable {
    companion object {
        fun getMovie(item: MovieItem): MovieResource = MovieResource(false, item)
        fun getFavMovie(item: MovieItem): MovieResource = MovieResource(true, item)
    }
}