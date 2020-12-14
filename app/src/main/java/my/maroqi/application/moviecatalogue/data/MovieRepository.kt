package my.maroqi.application.moviecatalogue.data

import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.source.local.MovieData

class MovieRepository : RepositorySource<MovieItem> {

    private var titles: ArrayList<String> = MovieData.titles
    private var years: ArrayList<Int> = MovieData.years
    private var releaseDate: ArrayList<String> = MovieData.releaseDate
    private var countries: ArrayList<String> = MovieData.country
    private var genres: ArrayList<String> = MovieData.genres
    private var durations: ArrayList<String> = MovieData.duration
    private var rating: ArrayList<Int> = MovieData.userScore
    private var descs: ArrayList<String> = MovieData.shortDesc
    private var teams: ArrayList<String> = MovieData.teams
    private var actors: ArrayList<String> = MovieData.actors

    override fun getListData(): ArrayList<MovieItem> {
        val movieListData: ArrayList<MovieItem> = arrayListOf()

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

    override fun getData(index: Int): MovieItem {
        return MovieItem(
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
    }
}