package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.hospitalizovani_list_item.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.model.Patient

class HospitalizovaniPatientViewHolder (
    override val containerView: View,
    onKartonClicked: (Int) -> Unit,
    onOtpustClicked: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        btn_karton.setOnClickListener{
            onKartonClicked(adapterPosition)
        }
        btn_otpust.setOnClickListener {
            onOtpustClicked(adapterPosition)
        }
    }

    fun bind(patient: Patient){
        Picasso
            .get()
            .load(patient.pictureUrl)
            .placeholder(R.drawable.profile_picture)
            .into(profilePic)
        patient_first_name.text = patient.first_name
        patient_last_name.text = patient.last_name
    }

}