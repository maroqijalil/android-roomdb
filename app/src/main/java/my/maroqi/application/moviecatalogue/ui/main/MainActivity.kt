package my.maroqi.application.moviecatalogue.ui.main

import android.content.Intent
import android.os.Bundle
import com.google.android.material.tabs.TabLayout
import androidx.viewpager.widget.ViewPager
import androidx.appcompat.app.AppCompatActivity
import my.maroqi.application.moviecatalogue.ui.detail.DataDetailsActivity
import my.maroqi.application.moviecatalogue.R
import my.maroqi.application.moviecatalogue.utility.ListItemType
import my.maroqi.application.moviecatalogue.ui.main.list.CatalogueListPagerAdapter
import my.maroqi.application.moviecatalogue.utility.NavigationHandler

class MainActivity : AppCompatActivity(), NavigationHandler {

    companion object {
        const val MAIN_DATA = "data_from_main"
        const val MAIN_DATA_TYPE = "type_data_from_main"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val sectionsPagerAdapter = CatalogueListPagerAdapter(this, supportFragmentManager)
        val viewPager: ViewPager = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)

        supportActionBar?.hide()
        tabs.setupWithViewPager(viewPager)
    }

    override fun navigateTo(index: Int, type: ListItemType) {
        val intent = Intent(this, DataDetailsActivity::class.java)

        intent.putExtra(MAIN_DATA, index)
        intent.putExtra(MAIN_DATA_TYPE, type)

        startActivity(intent)
    }
}