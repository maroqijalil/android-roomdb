package my.maroqi.application.moviecatalogue.ui.main

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.floatingactionbutton.FloatingActionButton
import my.maroqi.application.moviecatalogue.ui.detail.DataDetailsActivity
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.data.model.MovieItem
import my.maroqi.application.moviecatalogue.data.model.TVItem
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.ui.main.list.CatalogueListPagerAdapter
import my.maroqi.application.moviecatalogue.utility.MainHelper
import my.maroqi.application.moviecatalogue.utility.NavigationHandler

class MainActivity : AppCompatActivity(), NavigationHandler, MainHelper {

    private lateinit var btnFavOpen: FloatingActionButton

    companion object {
        const val MAIN_DATA = "data_from_main"
        const val MAIN_DATA_TYPE = "type_data_from_main"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportActionBar?.hide()

        val sectionsPagerAdapter = CatalogueListPagerAdapter(
            this,
            supportFragmentManager,
            CatalogueListPagerAdapter.listPageType["home"]
        )
        val viewPager: ViewPager = findViewById(R.id.view_pager)

        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)

        btnFavOpen = findViewById(R.id.btn_fav_open)
        btnFavOpen.setOnClickListener {
            val intent = Intent(this@MainActivity, FavouriteActivity::class.java)
            startActivity(intent)
        }

        tabs.setupWithViewPager(viewPager)
    }

    override fun navigateTo(index: Int, type: ListItemType, item: Any) {
        val intent = Intent(this, DataDetailsActivity::class.java)

        if (type == ListItemType.TV_SHOW) {
            intent.putExtra(MAIN_DATA, item as TVItem)
            intent.putExtra(MAIN_DATA_TYPE, type)
        } else if (type == ListItemType.MOVIE) {
            intent.putExtra(MAIN_DATA, item as MovieItem)
            intent.putExtra(MAIN_DATA_TYPE, type)
        }

        startActivity(intent)
    }

    override fun showToast(message: String) {
        runOnUiThread {
            Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
        }
    }
}