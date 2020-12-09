package my.maroqi.application.moviecatalogue.ui.main.list.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_data_list.view.*
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.ui.main.MainActivity
import my.maroqi.application.moviecatalogue.data.source.local.MovieData
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.source.local.TVData
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.utility.ListCaster
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.utility.MovieResource
import my.maroqi.application.moviecatalogue.utility.TVResource

class DataListViewHolder(v: View) : RecyclerView.ViewHolder(v) {

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    fun insertMovie(item: MovieResource, pos: Int) {
        with(itemView) {
            Picasso.get()
                .load(MovieData.drawables[item.movie.poster])
                .into(iv_main_poster)

            tv_main_title.text = item.movie.title
            tv_main_year.text = "(" + item.movie.year.toString() + ")"
            tv_main_genre.text = ListCaster.getStringList(item.movie.genre)
            tv_main_rating.text = item.movie.rating.toString()
            tv_main_teams.text = ListCaster.getStringListFromMap(item.movie.teams)
            tv_main_actor.text = ListCaster.getStringList(item.movie.actors)

            setupOnClick(pos, ListItemType.MOVIE)
        }
    }

    @SuppressLint("SetTextI18n")
    fun insertTV(item: TVResource, pos: Int) {
        with(itemView) {
            Picasso.get()
                .load(TVData.drawables[item.tv.poster])
                .into(iv_main_poster)

            tv_main_title.text = item.tv.title
            tv_main_year.text = "(" + item.tv.year.toString() + ")"
            tv_main_genre.text = ListCaster.getStringList(item.tv.genre)
            tv_main_rating.text = item.tv.rating.toString()
            tv_main_teams.text = ListCaster.getStringList(item.tv.teams)
            tv_main_actor.text = ListCaster.getStringList(item.tv.actors)

            setupOnClick(pos, ListItemType.TV_SHOW)
        }
    }

    private fun setupOnClick(pos: Int, type: ListItemType) {
        itemView.item_container.setOnClickListener {
            (it.context as MainActivity).navigateTo(pos, type)
        }
    }

    private fun setupFavButton(user: MovieResource) {
        with(itemView) {
            if (user.favourite) {
                Picasso.get()
                    .load(R.drawable.baseline_favorite_black_36dp)
                    .into(btn_fav_add)
            } else {
                Picasso.get()
                    .load(R.drawable.baseline_favorite_border_black_36dp)
                    .into(btn_fav_add)
            }
        }
    }
}