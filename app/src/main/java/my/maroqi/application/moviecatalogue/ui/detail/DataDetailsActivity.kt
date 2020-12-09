package my.maroqi.application.moviecatalogue.ui.detail

import android.annotation.SuppressLint
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.squareup.picasso.Picasso
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.data.source.local.MovieData
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.source.local.TVData
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.ui.main.MainActivity
import my.maroqi.application.moviecatalogue.ui.main.list.CatalogueListViewModel
import my.maroqi.application.moviecatalogue.utility.ListCaster
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.viewmodel.ViewModelFactory

class DataDetailsActivity : AppCompatActivity() {

    private lateinit var vmDataDetails: DataDetailsViewModel

    private lateinit var title: TextView
    private lateinit var year: TextView
    private lateinit var poster: ImageView
    private lateinit var releaseDate: TextView
    private lateinit var country: TextView
    private lateinit var genre: TextView
    private lateinit var duration: TextView
    private lateinit var desc: TextView
    private lateinit var teams: TextView
    private lateinit var rating: TextView
    private lateinit var actors: TextView

    private lateinit var type: ListItemType
    private var index: Int = 0

    private var movieItem: MovieItem? = null
    private var tvItem: TVItem? = null

    private lateinit var observerMovie: Observer<MovieItem>
    private lateinit var observerTV: Observer<TVItem>

    @RequiresApi(Build.VERSION_CODES.N)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data_details)

        setupItemView()
        setupView()
    }

    private fun setupItemView() {
        type = intent.getSerializableExtra(MainActivity.MAIN_DATA_TYPE) as ListItemType
        index = intent.getIntExtra(MainActivity.MAIN_DATA, 0)

        vmDataDetails = ViewModelProvider(
            this,
            ViewModelFactory(this, this)
        ).get(DataDetailsViewModel::class.java)

        title = findViewById(R.id.tv_detail_title)
        year = findViewById(R.id.tv_detail_year)
        poster = findViewById(R.id.iv_detail_poster)
        releaseDate = findViewById(R.id.tv_detail_release)
        country = findViewById(R.id.tv_detail_country)
        genre = findViewById(R.id.tv_detail_genre)
        duration = findViewById(R.id.tv_detail_duration)
        desc = findViewById(R.id.tv_detail_desc)
        teams = findViewById(R.id.tv_detail_teams)
        rating = findViewById(R.id.tv_detail_rating)
        actors = findViewById(R.id.tv_detail_actor)
    }

    @RequiresApi(Build.VERSION_CODES.N)
    private fun setupView() {
        vmDataDetails.setType(type, index)

        initDataDetail()
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun setupObserver() {
        if (type == ListItemType.MOVIE) {
            observerMovie = Observer {
                if (it != null) {
                    movieItem = it
                    insertMovieDetail()
                }
            }

            vmDataDetails.getMovieDetail().observe(this, observerMovie)
        } else if (type == ListItemType.TV_SHOW) {
            observerTV = Observer {
                if (it != null) {
                    tvItem = it
                    inserTVDetail()
                }
            }

            vmDataDetails.getTVDetail().observe(this, observerTV)
        }
    }

    private fun initDataDetail() {
        when {
            vmDataDetails.savedState.contains(CatalogueListViewModel.MOVIE_SVD) -> {
                movieItem = vmDataDetails.loadDataDetail() as MovieItem
                insertMovieDetail()
            }
            vmDataDetails.savedState.contains(CatalogueListViewModel.TV_SVD) -> {
                tvItem = vmDataDetails.loadDataDetail() as TVItem
                inserTVDetail()
            }
            else -> {
                setupObserver()
            }
        }
    }

    @SuppressLint("SetTextI18n")
    private fun insertMovieDetail() {
        title.text = movieItem?.title
        year.text = StringBuilder("(" + movieItem?.year.toString() + ")")

        Picasso.get()
            .load(MovieData.drawables[movieItem?.poster!!])
            .into(poster)

        releaseDate.text = movieItem?.releaseDate
        country.text = movieItem?.country
        genre.text = ListCaster.getStringList(movieItem?.genre)
        duration.text = movieItem?.duration
        desc.text = movieItem?.desc
        teams.text = ListCaster.getStringListFromMap(movieItem?.teams)
        rating.text = movieItem?.rating.toString()
        actors.text = ListCaster.getStringList(movieItem?.actors)
    }

    @SuppressLint("SetTextI18n")
    private fun inserTVDetail() {
        title.text = tvItem?.title
        year.text = StringBuilder("(" + tvItem?.year.toString() + ")")

        Picasso.get()
            .load(TVData.drawables[tvItem?.poster!!])
            .into(poster)

        releaseDate.text = tvItem?.releaseDate
        genre.text = ListCaster.getStringList(tvItem?.genre)
        country.visibility = View.GONE
        duration.text = tvItem?.duration
        desc.text = tvItem?.desc
        teams.text = ListCaster.getStringList(tvItem?.teams)
        rating.text = tvItem?.rating.toString()
        actors.text = ListCaster.getStringList(tvItem?.actors)
    }
}