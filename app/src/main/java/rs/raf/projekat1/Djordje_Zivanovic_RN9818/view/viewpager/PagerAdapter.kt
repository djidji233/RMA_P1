package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments.ListeFragment
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments.ProfilFragment
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments.StanjeFragment
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments.UnosFragment

class PagerAdapter(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 4
        const val FRAGMENT_STANJE = 0
        const val FRAGMENT_UNOS = 1
        const val FRAGMENT_LISTE = 2
        const val FRAGMENT_PROFIL = 3
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            FRAGMENT_STANJE -> StanjeFragment()
            FRAGMENT_UNOS -> UnosFragment()
            FRAGMENT_LISTE -> ListeFragment()
            else -> ProfilFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            FRAGMENT_STANJE -> "Stanje"
            FRAGMENT_UNOS -> "Unos"
            FRAGMENT_LISTE -> "Liste"
            else -> "Profil"
        }
    }

}