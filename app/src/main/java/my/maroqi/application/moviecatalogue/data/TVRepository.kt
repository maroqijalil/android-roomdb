package my.maroqi.application.moviecatalogue.data

import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.data.source.local.TVData

class TVRepository : RepositorySource<TVItem> {

    private var titles: ArrayList<String> = TVData.titles
    private var years: ArrayList<Int> = TVData.years
    private var releaseDate: ArrayList<String> = TVData.releaseDate
    private var genres: ArrayList<String> = TVData.genres
    private var durations: ArrayList<String> = TVData.duration
    private var rating: ArrayList<Int> = TVData.userScore
    private var descs: ArrayList<String> = TVData.shortDesc
    private var teams: ArrayList<String> = TVData.teams
    private var actors: ArrayList<String> = TVData.actors

    override fun getListData(): ArrayList<TVItem> {
        val tvListData: ArrayList<TVItem> = arrayListOf()

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

    override fun getData(index: Int): TVItem {
        return TVItem(
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
    }
}