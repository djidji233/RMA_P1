package rs.raf.projekat1.Djordje_Zivanovic_RN9818.viewmodels

import android.text.Editable
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.model.Patient
import java.util.*

class MainViewModel : ViewModel() {

    private val waiting_patients : MutableLiveData<List<Patient>> = MutableLiveData()
    private val waiting_patients_list : MutableList<Patient> = mutableListOf()
    private val hospitalized_patients : MutableLiveData<List<Patient>> = MutableLiveData()
    private val hospitalized_patients_list : MutableList<Patient> = mutableListOf()
    private val released_patients : MutableLiveData<List<Patient>> = MutableLiveData()
    private val released_patients_list : MutableList<Patient> = mutableListOf()
    private val pictureUrl: String = "https://www.jumpstarttech.com/files/2018/08/Network-Profile.png"
    private var nextId = 11


    init {
        for (i in 1..10){
            val patient = Patient(
                i,
                pictureUrl,
                "Name$i",
                "Nameovic$i",
                "Bas jezivi simptomi",
                Date()
            )
            patient.current_symptoms = patient.symptoms
            waiting_patients_list.add(patient)
        }
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(waiting_patients_list)
        waiting_patients.value = listToSubmit

    }

    fun getWaitingPatients() : LiveData<List<Patient>> {
        return waiting_patients
    }

    fun getHospitalizedPatients() : LiveData<List<Patient>> {
        return hospitalized_patients
    }

    fun getReleasedPatients() : LiveData<List<Patient>> {
        return released_patients
    }

    fun getListSize(i: Int): Int {
        if (i==0){
            return waiting_patients_list.size
        } else if (i==1){
            return hospitalized_patients_list.size
        } else if (i==2){
            return released_patients_list.size
        } else {
            return -1
        }
    }

    fun filterWaitingPatients(filter: String){
        val filteredList = waiting_patients_list.filter {
            it.first_name.toLowerCase().startsWith(filter.toLowerCase()) or
            it.last_name.toLowerCase().startsWith(filter.toLowerCase())
        }
        waiting_patients.value = filteredList
    }

    fun filterHospitalizedPatients(filter: String){
        val filteredList = hospitalized_patients_list.filter {
            it.first_name.toLowerCase().startsWith(filter.toLowerCase()) or
            it.last_name.toLowerCase().startsWith(filter.toLowerCase())
        }
        hospitalized_patients.value = filteredList
    }

    fun filterReleasedPatients(filter: String){
        val filteredList = released_patients_list.filter {
            it.first_name.toLowerCase().startsWith(filter.toLowerCase()) or
            it.last_name.toLowerCase().startsWith(filter.toLowerCase())
        }
        released_patients.value = filteredList
    }

    fun addWaitingPatient(name: String, lastname:String, sympt:String){
        val newP = Patient(nextId++,pictureUrl,name,lastname,sympt,Calendar.getInstance().time)
        newP.current_symptoms = newP.symptoms
        waiting_patients_list.add(newP)
        val listToSubmit = mutableListOf<Patient>()
        listToSubmit.addAll(waiting_patients_list)
        waiting_patients.value = listToSubmit
    }

    fun moveToHospitalized(p: Patient){
        hospitalized_patients_list.add(p)
        waiting_patients_list.remove(p)
        val listToSubmit1 = mutableListOf<Patient>()
        val listToSubmit2 = mutableListOf<Patient>()
        listToSubmit1.addAll(waiting_patients_list)
        listToSubmit2.addAll(hospitalized_patients_list)
        waiting_patients.value = listToSubmit1
        hospitalized_patients.value = listToSubmit2
    }

    fun moveToReleased(p: Patient, flag:Int){
        // flag = 0 from waiting, flag = 1 - from hospitalized
        p.release_date = Date()

        released_patients_list.add(p)
        val listToSubmit1 = mutableListOf<Patient>()
        listToSubmit1.addAll(released_patients_list)
        released_patients.value = listToSubmit1

        if(flag==1){
            hospitalized_patients_list.remove(p)
            val listToSubmit2 = mutableListOf<Patient>()
            listToSubmit2.addAll(hospitalized_patients_list)
            hospitalized_patients.value = listToSubmit2
        } else {
            waiting_patients_list.remove(p)
            val listToSubmit3 = mutableListOf<Patient>()
            listToSubmit3.addAll(waiting_patients_list)
            waiting_patients.value = listToSubmit3
        }
    }

    fun updateHospitalizedPatient(newPatient : Patient){
        for (p in hospitalized_patients_list){
            if (p.id == newPatient.id){
                p.first_name = newPatient.first_name
                p.last_name = newPatient.last_name
                p.symptoms = newPatient.symptoms
                p.current_symptoms = newPatient.current_symptoms

                val listToSubmit2 = mutableListOf<Patient>()
                listToSubmit2.addAll(hospitalized_patients_list)
                hospitalized_patients.value = listToSubmit2
            }
        }

    }

}