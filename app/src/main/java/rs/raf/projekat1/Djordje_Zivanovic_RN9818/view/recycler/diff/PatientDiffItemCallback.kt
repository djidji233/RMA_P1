package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.diff

import androidx.recyclerview.widget.DiffUtil
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.model.Patient

class PatientDiffItemCallback : DiffUtil.ItemCallback<Patient>() {

    override fun areItemsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Patient, newItem: Patient): Boolean {
        return oldItem.first_name == newItem.first_name &&
                oldItem.last_name == newItem.last_name &&
                oldItem.symptoms == newItem.symptoms &&
                oldItem.acceptance_date == newItem.acceptance_date &&
                oldItem.pictureUrl == newItem.pictureUrl
    }

}