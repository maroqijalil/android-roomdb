package my.maroqi.application.moviecatalogue.ui.main.list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.utility.MovieResource

class MoviePagedListAdapter(
    private val fragment: Fragment,
    private val pageType: Int
) : PagedListAdapter<MovieResource, DataListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataListViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_data_list, parent, false)
        return DataListViewHolder(viewHolder, fragment, pageType)
    }

    override fun onBindViewHolder(holder: DataListViewHolder, position: Int) {
        holder.insertMovie(getItem(position) as MovieResource, position)
    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<MovieResource> = object : DiffUtil.ItemCallback<MovieResource>() {
            override fun areItemsTheSame(oldNote: MovieResource, newNote: MovieResource): Boolean {
                return oldNote.movie.title == newNote.movie.title && oldNote.movie.desc == newNote.movie.desc
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldNote: MovieResource, newNote: MovieResource): Boolean {
                return oldNote == newNote
            }
        }
    }
}