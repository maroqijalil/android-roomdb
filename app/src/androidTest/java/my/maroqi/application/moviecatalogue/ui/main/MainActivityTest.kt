package my.maroqi.application.moviecatalogue.ui.main

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.data.source.local.MovieData
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.source.local.TVData
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.data.source.local.DataIdlingResource
import my.maroqi.application.moviecatalogue.utility.ListCaster
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    private val movieList = getMovieListData()
    private val tvList = getTVListData()

    @JvmField
    @Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(DataIdlingResource.dataIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(DataIdlingResource.dataIdlingResource)
    }

    @Test
    fun loadMovieList() {
        onView(allOf(isDisplayed(), withId(R.id.rv_main_list)))
    }

    @Test
    fun movieDetailTest() {
        onView(
            allOf(
                isDisplayed(),
                withId(R.id.rv_main_list)
            )
        ).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(4, click()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(movieList[4].title)))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(withText("(" + movieList[4].year.toString() + ")")))
        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_desc)).check(matches(withText(movieList[4].desc)))
        onView(withId(R.id.tv_detail_country)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_country)).check(matches(withText(movieList[4].country)))
        onView(withId(R.id.tv_detail_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_release)).check(matches(withText(movieList[4].releaseDate)))
        onView(withId(R.id.tv_detail_teams)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_teams)).check(
            matches(
                withText(
                    ListCaster.getStringListFromMap(
                        movieList[4].teams
                    )
                )
            )
        )
        onView(withId(R.id.tv_detail_actor)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_actor)).check(
            matches(
                withText(
                    ListCaster.getStringList(
                        movieList[4].actors
                    )
                )
            )
        )
    }

    @Test
    fun loadTVList() {
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        onView(allOf(isDisplayed(), withId(R.id.rv_main_list)))
    }

    @Test
    fun tvDetailTest() {
        onView(withId(R.id.view_pager)).perform(swipeLeft())
        onView(
            allOf(
                isDisplayed(),
                withId(R.id.rv_main_list)
            )
        ).perform(RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(2, click()))
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(tvList[2].title)))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(withText("(" + tvList[2].year.toString() + ")")))
        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_desc)).check(matches(withText(tvList[2].desc)))
        onView(withId(R.id.tv_detail_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_release)).check(matches(withText(tvList[2].releaseDate)))
        onView(withId(R.id.tv_detail_teams)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_teams)).check(matches(withText(ListCaster.getStringList(tvList[2].teams))))
        onView(withId(R.id.tv_detail_actor)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_actor)).check(matches(withText(ListCaster.getStringList(tvList[2].actors))))
    }

    private fun getMovieListData(): ArrayList<MovieItem> {
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

    private fun getTVListData(): ArrayList<TVItem> {
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
}
