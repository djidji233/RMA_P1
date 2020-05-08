package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.model.Patient
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.viewholder.CekaonicaPatientViewHolder

class CekaonicaPatientAdapter(
    patientDiffItemCallback: PatientDiffItemCallback,
    private val onZdravClicked: (Patient) -> Unit,
    private val onHospitalizacijaClicked: (Patient) -> Unit) : ListAdapter<Patient, CekaonicaPatientViewHolder>(patientDiffItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CekaonicaPatientViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.cekaonica_list_item, parent, false)
        return CekaonicaPatientViewHolder(
            containerView,
            {
                val patient = getItem(it)
                onZdravClicked(patient)
            },
            {
                val patient = getItem(it)
                onHospitalizacijaClicked(patient)
            }
        )
    }

    override fun onBindViewHolder(holder: CekaonicaPatientViewHolder, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }

}