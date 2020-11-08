package my.maroqi.application.moviecatalogue.ui.main.list

import android.annotation.SuppressLint
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
import my.maroqi.application.moviecatalogue.ui.main.list.adapter.DataListAdapter
import my.maroqi.application.moviecatalogue.ui.main.list.adapter.DataListDecoration
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.viewmodel.ViewModelFactory

class CatalogueListFragment : Fragment() {

    private lateinit var vmCatalogueList: CatalogueListViewModel
    private lateinit var mType: ListItemType

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
        val v = inflater.inflate(R.layout.fragment_list_catalogue, container, false)
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

        vmCatalogueList = ViewModelProvider(
            this,
            ViewModelFactory(this)
        ).get(CatalogueListViewModel::class.java)

        rvDataList = v.findViewById(R.id.rv_main_list)
    }

    private fun setupView() {
        vmCatalogueList.setType(mType)

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

        rvaDataList = DataListAdapter(dataList, mType)
    }
}