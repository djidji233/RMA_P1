package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_liste.*
import kotlinx.android.synthetic.main.fragment_liste_cekaonica.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.adapter.CekaonicaPatientAdapter
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.viewpager.PagerAdapterListe

class ListeFragment : Fragment(R.layout.fragment_liste) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        initTabs()
    }

    private fun initTabs() {
        viewPagerListe.adapter = PagerAdapterListe(childFragmentManager)
        tabLayout.setupWithViewPager(viewPagerListe)
    }


}