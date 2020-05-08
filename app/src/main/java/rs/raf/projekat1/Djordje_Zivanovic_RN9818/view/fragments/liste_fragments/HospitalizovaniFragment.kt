package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments.liste_fragments

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_liste_hospitalizovani.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.adapter.HospitalizovaniPatientAdapter
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.viewmodels.MainViewModel

class HospitalizovaniFragment: Fragment(R.layout.fragment_liste_hospitalizovani) {

    private val mainViewModel: MainViewModel by activityViewModels()
    private lateinit var patientAdapter: HospitalizovaniPatientAdapter

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
        patientAdapter = HospitalizovaniPatientAdapter(
            PatientDiffItemCallback(),
            {
                Toast.makeText(this.context, "Clicked on ${it.first_name}", Toast.LENGTH_SHORT).show()
            },
            {
                mainViewModel.delete(it)
            })
        recyclerList.adapter = patientAdapter
    }

    private fun initObservers() {
        mainViewModel.getHospitalizedPatients().observe(viewLifecycleOwner, Observer {
            patientAdapter.submitList(it)
        })
    }

    private fun initListeners(){
        searchText.doAfterTextChanged {
            mainViewModel.filterHospitalizedPatients(it.toString())
        }
    }
}