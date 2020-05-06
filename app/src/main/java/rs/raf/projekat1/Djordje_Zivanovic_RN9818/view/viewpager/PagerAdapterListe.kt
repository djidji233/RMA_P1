package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.viewpager

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments.liste_fragments.CekaonicaFragment
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments.liste_fragments.HospitalizovaniFragment
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments.liste_fragments.OtpusteniFragment

class PagerAdapterListe(fragmentManager: FragmentManager) : FragmentPagerAdapter(fragmentManager, BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT) {

    companion object {
        private const val ITEM_COUNT = 3
        const val FRAGMENT_CEKAONICA = 0
        const val FRAGMENT_HOSPITALIZOVANI = 1
        const val FRAGMENT_OTPUSTENI = 2
    }

    override fun getItem(position: Int): Fragment {
        return when(position) {
            FRAGMENT_CEKAONICA -> CekaonicaFragment()
            FRAGMENT_HOSPITALIZOVANI -> HospitalizovaniFragment()
            else -> OtpusteniFragment()
        }
    }

    override fun getCount(): Int {
        return ITEM_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return when(position) {
            FRAGMENT_CEKAONICA -> "Cekaonica"
            FRAGMENT_HOSPITALIZOVANI -> "Hospitalizovani"
            else -> "Otpusteni"
        }
    }
}