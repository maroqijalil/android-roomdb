package my.maroqi.application.moviecatalogue.ui.main

import android.content.Intent
import android.view.View
import android.widget.Button
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.action.ViewActions.swipeLeft
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.espresso.matcher.RootMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.data.source.local.MovieData
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.source.local.TVData
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.data.source.local.DataIdlingResource
import org.hamcrest.Matchers.allOf
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith
import androidx.test.espresso.ViewAction
import androidx.test.espresso.UiController
import androidx.test.runner.intent.IntentCallback
import my.maroqi.application.moviecatalogue.ui.detail.DataDetailsActivity
import my.maroqi.application.moviecatalogue.ui.favourite.FavouriteActivity
import org.hamcrest.Matcher
import org.hamcrest.Matchers.`is`
import org.hamcrest.Matchers.not

@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    private val movieList = getMovieListData()
    private val tvList = getTVListData()

    private val moviePosition = 4
    private val favMoviePosition = 2

    private val tvPosition = 2
    private val favTVPosition = 6

    private val initPosition = 0

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
        ).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                moviePosition,
                click()
            )
        )
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(movieList[moviePosition].title)))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(withText("(" + movieList[moviePosition].year.toString() + ")")))
//        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_detail_desc)).check(matches(withText(movieList[moviePosition].desc)))
        onView(withId(R.id.tv_detail_country)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_country)).check(matches(withText(movieList[moviePosition].country)))
        onView(withId(R.id.tv_detail_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_release)).check(matches(withText(movieList[moviePosition].releaseDate)))
        onView(withId(R.id.tv_detail_teams)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_teams)).check(
            matches(
                withText(
                    movieList[moviePosition].teams
                )
            )
        )
        onView(withId(R.id.tv_detail_actor)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_actor)).check(
            matches(
                withText(
                    movieList[moviePosition].actors
                )
            )
        )
    }

    @Test
    fun addFavMovie() {
        clickAddMovieFav()

        onView(withText(R.string.fav_movie_testing)).inRoot(withDecorView(not(`is`(activityRule.activity.window.decorView))))
            .check(
                matches(isDisplayed())
            )

        clickDelMovieFav()

        onView(withText(R.string.fav_movie_testing_del)).inRoot(withDecorView(not(`is`(activityRule.activity.window.decorView))))
            .check(
                matches(isDisplayed())
            )
    }

    @Test
    fun openFavMovieList() {
        onView(withId(R.id.btn_fav_open)).perform(click())
        onView(allOf(isDisplayed(), withId(R.id.rv_main_list)))
    }

    @Test
    fun favMovieDetailTest() {
        clickAddMovieFav()

        onView(withId(R.id.btn_fav_open)).perform(click())

        onView(
            allOf(
                isDisplayed(),
                withId(R.id.rv_main_list)
            )
        ).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                initPosition,
                click()
            )
        )

        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(movieList[favMoviePosition].title)))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(withText("(" + movieList[favMoviePosition].year.toString() + ")")))
//        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_detail_desc)).check(matches(withText(movieList[favMoviePosition].desc)))
        onView(withId(R.id.tv_detail_country)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_country)).check(matches(withText(movieList[favMoviePosition].country)))
        onView(withId(R.id.tv_detail_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_release)).check(matches(withText(movieList[favMoviePosition].releaseDate)))
        onView(withId(R.id.tv_detail_teams)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_teams)).check(
            matches(
                withText(
                    movieList[favMoviePosition].teams
                )
            )
        )
//        onView(withId(R.id.tv_detail_actor)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_actor)).check(
            matches(
                withText(
                    movieList[favMoviePosition].actors
                )
            )
        )

        var intent = Intent(activityRule.activity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TASK
        activityRule.activity.startActivity(intent)

        clickDelMovieFav()
    }

    private fun clickAddMovieFav() {
        onView(
            allOf(
                isDisplayed(),
                withId(R.id.rv_main_list)
            )
        ).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                favMoviePosition,
                clickChildWithId(R.id.btn_fav_add)
            )
        )
    }

    private fun clickDelMovieFav() {
        clickAddMovieFav()

        onView(withText(R.string.ask_yes)).inRoot(isDialog()).check(matches(isDisplayed())).perform(
            click()
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
        ).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                tvPosition,
                click()
            )
        )

        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(tvList[tvPosition].title)))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(withText("(" + tvList[tvPosition].year.toString() + ")")))
//        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_detail_desc)).check(matches(withText(tvList[tvPosition].desc)))
        onView(withId(R.id.tv_detail_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_release)).check(matches(withText(tvList[tvPosition].releaseDate)))
        onView(withId(R.id.tv_detail_teams)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_teams)).check(matches(withText(tvList[tvPosition].teams)))
        onView(withId(R.id.tv_detail_actor)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_actor)).check(matches(withText(tvList[tvPosition].actors)))
    }

    @Test
    fun addFavTV() {
        onView(withId(R.id.view_pager)).perform(swipeLeft())

        clickAddTVFav()

        onView(withText(R.string.fav_tv_testing)).inRoot(withDecorView(not(`is`(activityRule.activity.window.decorView))))
            .check(
                matches(isDisplayed())
            )

        clickDelTVFav()

        onView(withText(R.string.fav_tv_testing_del)).inRoot(withDecorView(not(`is`(activityRule.activity.window.decorView))))
            .check(
                matches(isDisplayed())
            )
    }

    @Test
    fun openFavTVList() {
        onView(withId(R.id.btn_fav_open)).perform(click())
        onView(withId(R.id.view_pager_fav)).perform(swipeLeft())
        onView(allOf(isDisplayed(), withId(R.id.rv_main_list)))
    }

    @Test
    fun favTVDetailTest() {
        onView(withId(R.id.view_pager)).perform(swipeLeft())

        clickAddTVFav()

        onView(withId(R.id.btn_fav_open)).perform(click())
        onView(withId(R.id.view_pager_fav)).perform(swipeLeft())

        onView(
            allOf(
                isDisplayed(),
                withId(R.id.rv_main_list)
            )
        ).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                initPosition,
                click()
            )
        )
        onView(withId(R.id.tv_detail_title)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_title)).check(matches(withText(tvList[favTVPosition].title)))
        onView(withId(R.id.tv_detail_year)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_year)).check(matches(withText("(" + tvList[favTVPosition].year.toString() + ")")))
//        onView(withId(R.id.tv_detail_desc)).check(matches(isDisplayed()))
//        onView(withId(R.id.tv_detail_desc)).check(matches(withText(tvList[favTVPosition].desc)))
        onView(withId(R.id.tv_detail_release)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_release)).check(matches(withText(tvList[favTVPosition].releaseDate)))
        onView(withId(R.id.tv_detail_teams)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_teams)).check(matches(withText(tvList[favTVPosition].teams)))
        onView(withId(R.id.tv_detail_actor)).check(matches(isDisplayed()))
        onView(withId(R.id.tv_detail_actor)).check(matches(withText(tvList[favTVPosition].actors)))

        var intent = Intent(activityRule.activity, MainActivity::class.java)
        intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
        activityRule.activity.startActivity(intent)

        onView(allOf(isDisplayed(), withId(R.id.rv_main_list)))
        onView(withId(R.id.view_pager)).perform(swipeLeft())

        clickDelTVFav()
    }

    private fun clickAddTVFav() {
        onView(
            allOf(
                isDisplayed(),
                withId(R.id.rv_main_list)
            )
        ).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(
                favTVPosition,
                clickChildWithId(R.id.btn_fav_add)
            )
        )
    }

    private fun clickDelTVFav() {
        clickAddTVFav()

        onView(withText(R.string.ask_yes)).inRoot(isDialog()).check(matches(isDisplayed())).perform(
            click()
        )
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

    fun clickChildWithId(id: Int): ViewAction {
        return object : ViewAction {
            override fun getConstraints(): Matcher<View>? {
                return null
            }

            override fun getDescription(): String {
                return "Click on a child view with specified id."
            }

            override fun perform(uiController: UiController?, view: View?) {
                var v = view?.findViewById<ImageView>(id);
                v?.performClick();
            }
        }
    }
}
