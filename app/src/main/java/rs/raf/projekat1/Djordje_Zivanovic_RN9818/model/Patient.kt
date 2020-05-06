package rs.raf.projekat1.Djordje_Zivanovic_RN9818.model

import java.util.*

data class Patient(
    val id: Int,
    var pictureUrl: String,
    var first_name: String,
    var last_name: String,
    var symptoms: String,
    var acceptance_date: Date
)
{
    var release_date: Date? = null
}