package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments.liste_fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import kotlinx.android.synthetic.main.fragment_liste_cekaonica.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.adapter.CekaonicaPatientAdapter
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.viewmodels.MainViewModel
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager


class CekaonicaFragment: Fragment(R.layout.fragment_liste_cekaonica) {

    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var patientAdapter: CekaonicaPatientAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initObservers()
        initRecycler()
        initListeners()
    }

    private fun initRecycler(){
        recyclerList.layoutManager = LinearLayoutManager(this.context)
        patientAdapter = CekaonicaPatientAdapter(
            PatientDiffItemCallback(),
            {
                mainViewModel.moveToReleased(it,0)
            },
            {
                mainViewModel.moveToHospitalized(it)
            })
        recyclerList.adapter = patientAdapter
    }

    private fun initObservers() {
        mainViewModel.getWaitingPatients().observe(viewLifecycleOwner, Observer {
            patientAdapter.submitList(it)
        })
    }

    private fun initListeners(){
        searchText.doAfterTextChanged {
            mainViewModel.filterWaitingPatients(it.toString())
        }
    }
}