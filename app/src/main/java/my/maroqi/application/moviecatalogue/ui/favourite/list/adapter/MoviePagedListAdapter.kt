package my.maroqi.application.moviecatalogue.ui.favourite.list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.ui.main.list.adapter.DataListViewHolder
import my.maroqi.application.moviecatalogue.utility.MainHelper
import my.maroqi.application.moviecatalogue.utility.MovieResource

class MoviePagedListAdapter(
    private val fragment: Fragment,
    private val pageType: Int?
) : PagedListAdapter<MovieItem, DataListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataListViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_data_list, parent, false)
        return DataListViewHolder(viewHolder, fragment, pageType!!)
    }

    override fun onBindViewHolder(holder: DataListViewHolder, position: Int) {
        holder.insertMovie(MovieResource.getFavMovie(getItem(position) as MovieItem), position)
    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<MovieItem> = object : DiffUtil.ItemCallback<MovieItem>() {
            override fun areItemsTheSame(oldNote: MovieItem, newNote: MovieItem): Boolean {
                return oldNote.title == newNote.title
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldNote: MovieItem, newNote: MovieItem): Boolean {
                return oldNote == newNote
            }
        }
    }
}