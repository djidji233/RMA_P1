package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments.liste_fragments

import android.app.Activity
import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.fragment_liste_hospitalizovani.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.model.Patient
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.activities.PatientKartonActivity
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
                val intent = Intent(this.context, PatientKartonActivity::class.java)
                intent.putExtra("patient", it)
                startActivityForResult(intent, 1)
            },
            {
                mainViewModel.moveToReleased(it,1)
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

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode==1 && resultCode==RESULT_OK) {
            val patient_old: Patient = data?.getParcelableExtra("patient") as Patient
            val patient_new: Patient = data.getParcelableExtra("patient_updated") as Patient
            mainViewModel.removeFromHospitalized(patient_old)
            mainViewModel.addToHospitalized(patient_new)
        }
    }
}