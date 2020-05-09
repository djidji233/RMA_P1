package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.activities

import android.app.Activity
import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_edit_profil.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import timber.log.Timber

class EditProfilActivity : AppCompatActivity() {

    private lateinit var shared_pref : SharedPreferences
    private val USER_DATA = "UserData"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_edit_profil)

        shared_pref = getSharedPreferences(USER_DATA, Context.MODE_PRIVATE)
        val user_fname = shared_pref.getString("user_first_name","ERROR [EditProfilActivity] user first name")
        user_first_name.setText(user_fname)
        val user_lname = shared_pref.getString("user_last_name", "ERROR [EditProfilActivity] user last name")
        user_last_name.setText(user_lname)
        val user_wrk = shared_pref.getString("user_workplace", "ERROR [EditProfilActivity] user workspace")
        user_workplace.setText(user_wrk)

        btn_edit_user_cancel.setOnClickListener(){
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        btn_edit_user_change.setOnClickListener(){
            if(user_first_name.text.isNotBlank() && user_last_name.text.isNotBlank() && user_workplace.text.isNotBlank()) {
                shared_pref.edit {
                    putString("user_first_name", user_first_name.text.toString())
                    putString("user_last_name", user_last_name.text.toString())
                    putString("user_workplace", user_workplace.text.toString())
                }
                setResult(Activity.RESULT_OK)
                finish()
            } else {
                Toast.makeText(applicationContext,"Please fill in all the fields!", Toast.LENGTH_SHORT).show()
            }
        }

    }


}