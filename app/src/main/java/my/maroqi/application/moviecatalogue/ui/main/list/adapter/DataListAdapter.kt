package my.maroqi.application.moviecatalogue.ui.main.list.adapter

import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.model.TVItem

class DataListAdapter(genList: ArrayList<*>?, private val type: ListItemType) :
    RecyclerView.Adapter<DataListViewHolder>() {

    private val movieList: ArrayList<MovieItem> = arrayListOf()
    private val tvList: ArrayList<TVItem> = arrayListOf()
    private var listSize: Int = 0

    init {
        if (genList != null)
            changeDataList(genList)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataListViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_data_list, parent, false)
        return DataListViewHolder(viewHolder)
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
            movieList.addAll(list as ArrayList<MovieItem>)
            listSize = movieList.size
        } else if (type == ListItemType.TV_SHOW) {
            tvList.addAll(list as ArrayList<TVItem>)
            listSize = tvList.size
        }

        notifyDataSetChanged()
    }
}