package my.maroqi.application.moviecatalogue.ui.main.list

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
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.ui.favourite.list.FavouriteListViewModel
import my.maroqi.application.moviecatalogue.ui.main.list.adapter.DataListAdapter
import my.maroqi.application.moviecatalogue.ui.main.list.adapter.DataListDecoration
import my.maroqi.application.moviecatalogue.utility.*
import my.maroqi.application.moviecatalogue.viewmodel.ViewModelFactory

class CatalogueListFragment() : Fragment(), DBHelper, MainHelper {

    private lateinit var vmCatalogueList: CatalogueListViewModel
    private lateinit var mType: ListItemType
    private lateinit var alertDialog: AlertDialog.Builder

    private lateinit var rvDataList: RecyclerView
    private lateinit var rvaDataList: DataListAdapter

    private lateinit var ctx: Context

    private lateinit var observerDataList: Observer<ArrayList<*>>
    private var dataList: ArrayList<*>? = null

    companion object {
        const val FRAGMENT_TYPE = "fragment_tab_type"

        @JvmStatic
        fun newInstance(pos: Int): CatalogueListFragment {
            val fr = CatalogueListFragment()
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
        alertDialog = AlertDialog.Builder(ctx, R.style.Theme_AppCompat_DayNight_Dialog_Alert)

        vmCatalogueList = ViewModelProvider(
            this,
            ViewModelFactory(ctx, this)
        ).get(CatalogueListViewModel::class.java)

        vmCatalogueList.setType(mType)

        rvDataList = v.findViewById(R.id.rv_main_list)
    }

    private fun setupView() {
        initRVADataList()

        rvDataList.apply {
            setHasFixedSize(true)
            adapter = rvaDataList
            layoutManager = LinearLayoutManager(ctx)
            addItemDecoration(DataListDecoration(16))
        }
    }

    @SuppressLint("FragmentLiveDataObserve")
    private fun setupObserver() {
        observerDataList = Observer {
            if (it.size > 0) {
                rvaDataList.changeDataList(it)
                dataList = it
            }
        }

        vmCatalogueList.getDataList().observe(this, observerDataList)
    }

    private fun initRVADataList() {
        if (vmCatalogueList.savedState.contains(CatalogueListViewModel.MOVIE_SVD) ||
            vmCatalogueList.savedState.contains(CatalogueListViewModel.TV_SVD)
        ) {
            dataList = vmCatalogueList.loadDataList()
        } else
            setupObserver()

        rvaDataList =
            DataListAdapter(this, dataList, mType, CatalogueListPagerAdapter.listPageType["home"])
    }

    override fun insertFavMovie(item: MovieResource) {
        vmCatalogueList.insertFavMovie(item.movie)
    }

    override fun insertFavTV(item: TVResource) {
        vmCatalogueList.insertFavTV(item.tv)
    }

    override fun showAlert(
        title: String,
        msg: String,
        item: Any,
        type: ListItemType,
        position: Int
    ) {
        alertDialog.setTitle(title)
            .setMessage(msg)
            .setPositiveButton(getString(R.string.ask_yes)) { _, _ ->
                if (type == ListItemType.TV_SHOW) {
                    vmCatalogueList.deleteFavTV((item as TVResource).tv)
                    rvaDataList.deleteData(position)
                    showToast((item as TVResource).tv.title + " " + getString(R.string.del_title2))
                } else if (type == ListItemType.MOVIE) {
                    vmCatalogueList.deleteFavMovie((item as MovieResource).movie)
                    showToast((item as MovieResource).movie.title + " " + getString(R.string.del_title2))
                }
            }
            .setNegativeButton(getString(R.string.ask_no)) { dialog, _ -> dialog.cancel() }
            .create().show()
    }

    override fun showToast(message: String) {
        (ctx as MainHelper).showToast(message)
    }
}