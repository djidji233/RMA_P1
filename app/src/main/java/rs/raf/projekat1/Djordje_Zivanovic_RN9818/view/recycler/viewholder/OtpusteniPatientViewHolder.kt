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

class OtpusteniPatientViewHolder (override val containerView: View) : RecyclerView.ViewHolder(containerView), LayoutContainer {

    fun bind(patient: Patient){
        Picasso
            .get()
            .load(patient.pictureUrl)
            .placeholder(R.drawable.profile_picture)
            .into(profilePic)
        patient_first_name.text = patient.first_name
        patient_last_name.text = patient.last_name

        val datePattern = "dd.MM.yyyy"
        val dateFormat = SimpleDateFormat(datePattern)
        patient_release_date.text = "Otpusten: " + dateFormat.format(patient.release_date)
    }

}