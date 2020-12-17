package my.maroqi.application.moviecatalogue.ui.favourite.list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.ui.main.list.adapter.DataListViewHolder
import my.maroqi.application.moviecatalogue.utility.MainHelper
import my.maroqi.application.moviecatalogue.utility.TVResource

class TVPagedListAdapter(
    private val fragment: Fragment,
    private val pageType: Int?
) : PagedListAdapter<TVItem, DataListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataListViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_data_list, parent, false)
        return DataListViewHolder(viewHolder, fragment, pageType!!)
    }

    override fun onBindViewHolder(holder: DataListViewHolder, position: Int) {
        holder.insertTV(TVResource.getFavTV(getItem(position) as TVItem), position)
        (fragment.context as MainHelper).showToast((getItem(position) as TVItem).title!!)
    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<TVItem> = object : DiffUtil.ItemCallback<TVItem>() {
            override fun areItemsTheSame(oldNote: TVItem, newNote: TVItem): Boolean {
                return oldNote.title == newNote.title && oldNote.desc == newNote.desc
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldNote: TVItem, newNote: TVItem): Boolean {
                return oldNote == newNote
            }
        }
    }
}