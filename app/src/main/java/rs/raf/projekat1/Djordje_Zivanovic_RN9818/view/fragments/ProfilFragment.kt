package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments

import android.app.Activity
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.view.View
import androidx.core.content.edit
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_profil.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.activities.EditProfilActivity
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.activities.LoginActivity

class ProfilFragment : Fragment(R.layout.fragment_profil){

    private lateinit var shared_pref : SharedPreferences
    private val USER_DATA = "UserData"

    private fun fillInData(){
        shared_pref = this.requireActivity().getSharedPreferences(USER_DATA, Context.MODE_PRIVATE)
        val user_fname = shared_pref.getString("user_first_name","ERROR [ProfilFragment] user first name")
        user_first_name.setText(user_fname)
        val user_lname = shared_pref.getString("user_last_name", "ERROR [ProfilFragment] user last name")
        user_last_name.setText(user_lname)
        val user_wrk = shared_pref.getString("user_workplace", "ERROR [ProfilFragment] user workspace")
        user_workplace.setText(user_wrk)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fillInData()

        btn_edit_user.setOnClickListener(){
            val intent = Intent(this.context, EditProfilActivity::class.java)
            startActivityForResult(intent, 1)
        }

        btn_logout.setOnClickListener(){
            val intent = Intent(this.context, LoginActivity::class.java)
            shared_pref.edit().clear().apply()
            startActivity(intent)
            this.requireActivity().finish()
        }

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        fillInData()
    }

}