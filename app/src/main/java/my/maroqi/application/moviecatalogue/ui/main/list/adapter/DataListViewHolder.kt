package my.maroqi.application.moviecatalogue.ui.main.list.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.View
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.item_data_list.view.*
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.ui.main.MainActivity
import my.maroqi.application.moviecatalogue.data.source.local.MovieData
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.source.local.TVData
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.utility.*

class DataListViewHolder(v: View, private val fragment: Fragment) : RecyclerView.ViewHolder(v) {

    @RequiresApi(Build.VERSION_CODES.N)
    @SuppressLint("SetTextI18n")
    fun insertMovie(item: MovieResource, pos: Int) {
        with(itemView) {
            Picasso.get()
                .load(MovieData.drawables[item.movie.poster])
                .into(iv_main_poster)

            setupFavButtonMovie(item)

            tv_main_title.text = item.movie.title
            tv_main_year.text = "(" + item.movie.year.toString() + ")"
            tv_main_genre.text = item.movie.genre
            tv_main_rating.text = item.movie.rating.toString()
            tv_main_teams.text = item.movie.teams
            tv_main_actor.text = item.movie.actors

            setupOnClick(pos, ListItemType.MOVIE)

            btn_fav_add.setOnClickListener{
                if (item.favourite) {
                    (fragment as DBHelper).showAlert(
                        context.getString(R.string.del_title),
                        context.getString(R.string.del_question) + " " + item.movie.title,
                        item, ListItemType.MOVIE, pos
                    )
                } else {
                    (fragment as DBHelper).insertFavMovie(item)
                    (fragment as MainHelper).showToast(item.movie.title + " " + context.getString(
                        R.string.in_title))

                    item.favourite = true
                    setupFavButtonMovie(item)
                }
            }
        }
    }

    @SuppressLint("SetTextI18n")
    fun insertTV(item: TVResource, pos: Int) {
        with(itemView) {
            Picasso.get()
                .load(TVData.drawables[item.tv.poster])
                .into(iv_main_poster)

            setupFavButtonTV(item)

            tv_main_title.text = item.tv.title
            tv_main_year.text = "(" + item.tv.year.toString() + ")"
            tv_main_genre.text = item.tv.genre
            tv_main_rating.text = item.tv.rating.toString()
            tv_main_teams.text = item.tv.teams
            tv_main_actor.text = item.tv.actors

            setupOnClick(pos, ListItemType.TV_SHOW)

            btn_fav_add.setOnClickListener{
                if (item.favourite) {
                    (fragment as DBHelper).showAlert(
                        context.getString(R.string.del_title),
                        context.getString(R.string.del_question) + " " + item.tv.title,
                        item, ListItemType.TV_SHOW, pos
                    )
                } else {
                    (fragment as DBHelper).insertFavTV(item)
                    (fragment as MainHelper).showToast(item.tv.title + " " + context.getString(
                        R.string.in_title))

//                    item.favourite = true
//                    setupFavButtonTV(item)
                }
            }
        }
    }

    private fun setupOnClick(pos: Int, type: ListItemType) {
        itemView.item_container.setOnClickListener {
            (it.context as MainActivity).navigateTo(pos, type)
        }
    }

    private fun setupFavButtonMovie(item: MovieResource) {
        with(itemView) {
            if (item.favourite) {
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

    private fun setupFavButtonTV(item: TVResource) {
        with(itemView) {
            if (item.favourite) {
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