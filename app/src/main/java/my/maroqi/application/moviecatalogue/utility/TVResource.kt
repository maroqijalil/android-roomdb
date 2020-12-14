package my.maroqi.application.moviecatalogue.utility

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import my.maroqi.application.moviecatalogue.data.model.TVItem

@Parcelize
class TVResource(var favourite: Boolean, val tv: TVItem): Parcelable {
    companion object {
        fun getTV(item: TVItem): TVResource = TVResource(false, item)
        fun getFavTV(item: TVItem): TVResource = TVResource(true, item)
    }
}