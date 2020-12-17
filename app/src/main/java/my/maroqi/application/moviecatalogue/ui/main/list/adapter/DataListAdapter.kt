package my.maroqi.application.moviecatalogue.ui.main.list.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.utility.MovieResource
import my.maroqi.application.moviecatalogue.utility.TVResource

class DataListAdapter(
    fr: Fragment,
    genList: ArrayList<*>?,
    private val type: ListItemType,
    private val pageType: Int?
) :
    RecyclerView.Adapter<DataListViewHolder>() {

    private val movieList: ArrayList<MovieResource> = arrayListOf()
    private val tvList: ArrayList<TVResource> = arrayListOf()
    private var listSize: Int = 0
    private val fragment = fr

    init {
        if (genList != null)
            changeDataList(genList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataListViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_data_list, parent, false)
        return DataListViewHolder(viewHolder, fragment, pageType!!)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onBindViewHolder(holder: DataListViewHolder, position: Int) {
        if (position < listSize) {
            if (type == ListItemType.MOVIE) {
                holder.insertMovie(movieList[position], position)
            } else if (type == ListItemType.TV_SHOW) {
                holder.insertTV(tvList[position], position)
            }
        }
    }

    override fun getItemCount(): Int {
        return listSize
    }

    fun changeDataList(list: ArrayList<*>) {
        if (type == ListItemType.MOVIE) {
            if (movieList.size > 0)
                movieList.clear()
            movieList.addAll(list as ArrayList<MovieResource>)
            listSize = movieList.size
        } else if (type == ListItemType.TV_SHOW) {
            if (tvList.size > 0)
                tvList.clear()
            tvList.addAll(list as ArrayList<TVResource>)
            listSize = tvList.size
        }

        notifyDataSetChanged()
    }

    fun deleteData(pos: Int) {
        if (type == ListItemType.MOVIE) {
            movieList.removeAt(pos)
            listSize = movieList.size
        } else if (type == ListItemType.TV_SHOW) {
            tvList.removeAt(pos)
            listSize = tvList.size
        }

        notifyDataSetChanged()
    }
}