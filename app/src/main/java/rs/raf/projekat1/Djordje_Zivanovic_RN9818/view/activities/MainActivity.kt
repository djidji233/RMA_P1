package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.activities

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.get
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.fragment_stanje.view.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments.ListeFragment
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.viewpager.PagerAdapter
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.viewmodels.MainViewModel

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        init()
    }

    private fun init() {
        initViewPager()
        initNavigation()
    }

    private fun initViewPager() {
       viewPager.adapter = PagerAdapter(supportFragmentManager)
    }

    // povezuje navigaciju sa view pagerom
    private fun initNavigation() {
        bottomNavigation.setOnNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_stanje ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_STANJE, false)
                }
                R.id.menu_unos ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_UNOS, false)
                }
                R.id.menu_liste ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_LISTE, false)
                }
                R.id.menu_profil ->  {
                    viewPager.setCurrentItem(PagerAdapter.FRAGMENT_PROFIL, false)
                }
            }
            true
        }
    }

}