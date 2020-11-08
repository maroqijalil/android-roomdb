package my.maroqi.application.moviecatalogue.ui.main.list

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import my.maroqi.application.moviecatalogue.R

class CatalogueListPagerAdapter(private val context: Context, fm: FragmentManager) :
    FragmentPagerAdapter(fm, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        val TAB_TITLES = arrayOf(
            R.string.tab_title_movie,
            R.string.tab_title_tv
        )
    }

    override fun getItem(position: Int): Fragment {
        return CatalogueListFragment.newInstance(position)
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return context.resources.getString(TAB_TITLES[position])
    }

    override fun getCount(): Int {
        return 2
    }
}