package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.ListAdapter
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.model.Patient
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.diff.PatientDiffItemCallback
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.viewholder.OtpusteniPatientViewHolder

class OtpusteniPatientAdapter(
    patientDiffItemCallback: PatientDiffItemCallback) : ListAdapter<Patient, OtpusteniPatientViewHolder>(patientDiffItemCallback){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): OtpusteniPatientViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val containerView = layoutInflater.inflate(R.layout.otpusteni_list_item, parent, false)
        return OtpusteniPatientViewHolder(containerView)
    }

    override fun onBindViewHolder(holder: OtpusteniPatientViewHolder, position: Int) {
        val patient = getItem(position)
        holder.bind(patient)
    }

}