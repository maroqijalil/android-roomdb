package my.maroqi.application.tvcatalogue.ui.main.list.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.paging.PagedListAdapter
import androidx.recyclerview.widget.DiffUtil
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.ui.main.list.adapter.DataListViewHolder
import my.maroqi.application.moviecatalogue.utility.TVResource

class TVPagedListAdapter(
    private val fragment: Fragment,
    private val pageType: Int
) : PagedListAdapter<TVResource, DataListViewHolder>(DIFF_CALLBACK) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataListViewHolder {
        val viewHolder =
            LayoutInflater.from(parent.context).inflate(R.layout.item_data_list, parent, false)
        return DataListViewHolder(viewHolder, fragment, pageType)
    }

    override fun onBindViewHolder(holder: DataListViewHolder, position: Int) {
        holder.insertTV(getItem(position) as TVResource, position)
    }

    companion object {
        private val DIFF_CALLBACK: DiffUtil.ItemCallback<TVResource> = object : DiffUtil.ItemCallback<TVResource>() {
            override fun areItemsTheSame(oldNote: TVResource, newNote: TVResource): Boolean {
                return oldNote.tv.title == newNote.tv.title && oldNote.tv.desc == newNote.tv.desc
            }

            @SuppressLint("DiffUtilEquals")
            override fun areContentsTheSame(oldNote: TVResource, newNote: TVResource): Boolean {
                return oldNote == newNote
            }
        }
    }
}