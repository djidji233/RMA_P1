package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.recycler.viewholder

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.otpusteni_list_item.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.model.Patient
import java.text.SimpleDateFormat
import java.util.*

class OtpusteniPatientViewHolder (
    override val containerView: View,
    onItemClicked: (Int) -> Unit,
    onDeleteClicked: (Int) -> Unit) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    init {
        containerView.setOnClickListener{
            onItemClicked(adapterPosition)
        }
//        btn_karton.setOnClickListener {
//            onDeleteClicked(adapterPosition)
//        }
    }

    fun bind(patient: Patient){
        Picasso
            .get()
            .load(patient.pictureUrl)
            .placeholder(R.drawable.profile_picture)
            .into(profilePic)
        patient_first_name.text = patient.first_name
        patient_last_name.text = patient.last_name

        patient.release_date = Date()
        val datePattern = "dd.MM.yyyy"
        val dateFormat = SimpleDateFormat(datePattern)
        patient_release_date.text = "Otpusten: " + dateFormat.format(patient.release_date)
    }

}