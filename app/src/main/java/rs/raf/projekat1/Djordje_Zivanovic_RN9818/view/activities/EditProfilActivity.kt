package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.activities

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_edit_profil.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import timber.log.Timber

class EditProfilActivity : AppCompatActivity(R.layout.activity_edit_profil) {

    private lateinit var shared_pref : SharedPreferences
    private val USER_DATA = "UserData"

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        super.onCreate(savedInstanceState, persistentState)

        shared_pref = getSharedPreferences(USER_DATA, Context.MODE_PRIVATE)
        val user_fname = shared_pref.getString("user_first_name","ERROR [EditProfilActivity] user first name")
        user_first_name.setText(user_fname)
        val user_lname = shared_pref.getString("user_last_name", "ERROR [EditProfilActivity] user last name")
        user_last_name.setText(user_lname)
        val user_wrk = shared_pref.getString("user_workplace", "ERROR [EditProfilActivity] user workspace")
        user_workplace.setText(user_wrk)

    }


}