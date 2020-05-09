package rs.raf.projekat1.Djordje_Zivanovic_RN9818.model

import android.os.Parcelable
import kotlinx.android.parcel.IgnoredOnParcel
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class Patient(
    val id: Int,
    var pictureUrl: String,
    var first_name: String,
    var last_name: String,
    var symptoms: String,
    var acceptance_date: Date
) : Parcelable {

    var current_symptoms: String? = null
    var release_date: Date? = null
}