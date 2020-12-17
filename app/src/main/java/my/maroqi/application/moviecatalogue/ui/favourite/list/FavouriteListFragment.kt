package my.maroqi.application.moviecatalogue.ui.favourite.list

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.paging.PagedList
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.ui.favourite.list.adapter.MoviePagedListAdapter
import my.maroqi.application.moviecatalogue.ui.favourite.list.adapter.TVPagedListAdapter
import my.maroqi.application.moviecatalogue.ui.main.list.CatalogueListPagerAdapter
import my.maroqi.application.moviecatalogue.ui.main.list.adapter.DataListAdapter
import my.maroqi.application.moviecatalogue.ui.main.list.adapter.DataListDecoration
import my.maroqi.application.moviecatalogue.utility.*
import my.maroqi.application.moviecatalogue.viewmodel.ViewModelFactory

class FavouriteListFragment() : Fragment() {

    private lateinit var vmFavouriteList: FavouriteListViewModel
    private lateinit var mType: ListItemType

    private lateinit var rvDataList: RecyclerView
    private lateinit var rvaMovieList: MoviePagedListAdapter
    private lateinit var rvaTVList: TVPagedListAdapter

    private lateinit var ctx: Context

    private lateinit var observerMovieList: Observer<PagedList<MovieItem>>
    private lateinit var observerTVList: Observer<PagedList<TVItem>>

    companion object {
        const val FRAGMENT_TYPE = "fragment_tab_type"

        @JvmStatic
        fun newInstance(pos: Int): FavouriteListFragment {
            val fr = FavouriteListFragment()
            val bundle = Bundle()

            if (CatalogueListPagerAdapter.TAB_TITLES[pos] == CatalogueListPagerAdapter.TAB_TITLES[0])
                bundle.putSerializable(FRAGMENT_TYPE, ListItemType.MOVIE)
            else if (CatalogueListPagerAdapter.TAB_TITLES[pos] == CatalogueListPagerAdapter.TAB_TITLES[1])
                bundle.putSerializable(FRAGMENT_TYPE, ListItemType.TV_SHOW)

            fr.arguments = bundle

            return fr
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        var v: View? = null

        v = inflater.inflate(R.layout.fragment_list_catalogue, container, false)
        setupitemView(v)

        return v
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupView()
    }

    private fun setupitemView(v: View) {
        mType = arguments?.getSerializable(FRAGMENT_TYPE) as ListItemType
        ctx = v.context

        vmFavouriteList = ViewModelProvider(
            this,
            ViewModelFactory(ctx, this)
        ).get(FavouriteListViewModel::class.java)

        rvDataList = v.findViewById(R.id.rv_main_list)

        if (mType == ListItemType.TV_SHOW) {
            rvaTVList = TVPagedListAdapter(this, CatalogueListPagerAdapter.listPageType["fav"])
        } else if (mType == ListItemType.MOVIE) {
            rvaMovieList = MoviePagedListAdapter(this, CatalogueListPagerAdapter.listPageType["home"])
        }
    }

    private fun setupView() {
        setupObserver()

        if (mType == ListItemType.TV_SHOW) {
            rvDataList.apply {
                adapter = rvaTVList
                layoutManager = LinearLayoutManager(ctx)
                addItemDecoration(DataListDecoration(16))
            }
        } else if (mType == ListItemType.MOVIE) {
            rvDataList.apply {
                adapter = rvaMovieList
                layoutManager = LinearLayoutManager(ctx)
                addItemDecoration(DataListDecoration(16))
            }
        }
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun setupObserver() {
        if (mType == ListItemType.TV_SHOW) {
            observerTVList = Observer {
                if (it != null) {
                    rvaTVList.submitList(it)
                }
            }
            vmFavouriteList.getAllTV().observe(this, observerTVList)
        } else if (mType == ListItemType.MOVIE) {
            observerMovieList = Observer {
                if (it != null) {
                    rvaMovieList.submitList(it)
                }
            }
            vmFavouriteList.getAllMovie().observe(this, observerMovieList)
        }
    }
}