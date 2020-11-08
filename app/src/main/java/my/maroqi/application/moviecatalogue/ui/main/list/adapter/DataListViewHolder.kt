package my.maroqi.application.moviecatalogue.ui.main.list.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_data_list.view.*
import my.maroqi.application.moviecatalogue.ui.main.MainActivity
import my.maroqi.application.moviecatalogue.data.source.local.MovieData
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.source.local.TVData
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.utility.ListCaster
import my.maroqi.application.moviecatalogue.utility.ListItemType

class DataListViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    fun insertMovie(item: MovieItem, pos: Int) {
        with(itemView) {
            Picasso.get()
                .load(MovieData.drawables[item.poster])
                .into(iv_main_poster)

            tv_main_title.text = item.title
            tv_main_year.text = "(" + item.year.toString() + ")"
            tv_main_genre.text = ListCaster.getStringList(item.genre)
            tv_main_rating.text = item.rating.toString()
            tv_main_teams.text = ListCaster.getStringListFromMap(item.teams)
            tv_main_actor.text = ListCaster.getStringList(item.actors)

            setupOnClick(pos, ListItemType.MOVIE)
        }
    }

    @SuppressLint("SetTextI18n")
    fun insertTV(item: TVItem, pos: Int) {
        with(itemView) {
            Picasso.get()
                .load(TVData.drawables[item.poster])
                .into(iv_main_poster)

            tv_main_title.text = item.title
            tv_main_year.text = "(" + item.year.toString() + ")"
            tv_main_genre.text = ListCaster.getStringList(item.genre)
            tv_main_rating.text = item.rating.toString()
            tv_main_teams.text = ListCaster.getStringList(item.teams)
            tv_main_actor.text = ListCaster.getStringList(item.actors)

            setupOnClick(pos, ListItemType.TV_SHOW)
        }
    }

    private fun setupOnClick(pos: Int, type: ListItemType) {
        itemView.item_container.setOnClickListener {
            (it.context as MainActivity).navigateTo(pos, type)
        }
    }
}