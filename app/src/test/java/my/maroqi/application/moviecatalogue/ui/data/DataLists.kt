package my.maroqi.application.moviecatalogue.ui.data

import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.data.source.local.MovieData
import my.maroqi.application.moviecatalogue.data.source.local.TVData

class DataLists {
    companion object {
        fun getMovieListData(): ArrayList<MovieItem> {
            val movieListData: ArrayList<MovieItem> = arrayListOf()

            val titles = MovieData.titles
            val years = MovieData.years
            val releaseDate = MovieData.releaseDate
            val countries = MovieData.country
            val genres = MovieData.genres
            val durations = MovieData.duration
            val rating = MovieData.userScore
            val descs = MovieData.shortDesc
            val teams = MovieData.teams
            val actors = MovieData.actors

            titles.forEachIndexed { i, _ ->
                val movieItem = MovieItem(
                    title = titles[i],
                    year = years[i],
                    poster = i,
                    releaseDate = releaseDate[i],
                    country = countries[i],
                    genre = genres[i],
                    duration = durations[i],
                    rating = rating[i],
                    desc = descs[i],
                    teams = teams[i],
                    actors = actors[i]
                )

                movieListData.add(movieItem)
            }

            return movieListData
        }

        fun getTVListData(): ArrayList<TVItem> {
            val tvListData: ArrayList<TVItem> = arrayListOf()

            val titles = TVData.titles
            val years = TVData.years
            val releaseDate = TVData.releaseDate
            val genres = TVData.genres
            val durations = TVData.duration
            val rating = TVData.userScore
            val descs = TVData.shortDesc
            val teams = TVData.teams
            val actors = TVData.actors

            titles.forEachIndexed { i, _ ->
                val tvItem = TVItem(
                    title = titles[i],
                    year = years[i],
                    poster = i,
                    releaseDate = releaseDate[i],
                    genre = genres[i],
                    duration = durations[i],
                    rating = rating[i],
                    desc = descs[i],
                    teams = teams[i],
                    actors = actors[i]
                )

                tvListData.add(tvItem)
            }

            return tvListData
        }

        fun getMovieDetail(index: Int): MovieItem {
            val titles = MovieData.titles
            val years = MovieData.years
            val releaseDate = MovieData.releaseDate
            val countries = MovieData.country
            val genres = MovieData.genres
            val durations = MovieData.duration
            val rating = MovieData.userScore
            val descs = MovieData.shortDesc
            val teams = MovieData.teams
            val actors = MovieData.actors

            val movieItem = MovieItem(
                title = titles[index],
                year = years[index],
                poster = index,
                releaseDate = releaseDate[index],
                country = countries[index],
                genre = genres[index],
                duration = durations[index],
                rating = rating[index],
                desc = descs[index],
                teams = teams[index],
                actors = actors[index]
            )

            return movieItem
        }

        fun getTVDetail(index: Int): TVItem {
            val titles = TVData.titles
            val years = TVData.years
            val releaseDate = TVData.releaseDate
            val genres = TVData.genres
            val durations = TVData.duration
            val rating = TVData.userScore
            val descs = TVData.shortDesc
            val teams = TVData.teams
            val actors = TVData.actors

            val tvItem = TVItem(
                title = titles[index],
                year = years[index],
                poster = index,
                releaseDate = releaseDate[index],
                genre = genres[index],
                duration = durations[index],
                rating = rating[index],
                desc = descs[index],
                teams = teams[index],
                actors = actors[index]
            )

            return tvItem
        }
    }
}