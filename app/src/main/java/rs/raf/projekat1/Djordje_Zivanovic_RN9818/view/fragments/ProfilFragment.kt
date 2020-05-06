package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments

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

class ProfilFragment : Fragment(R.layout.fragment_profil){

    private lateinit var shared_pref : SharedPreferences
    private val USER_DATA = "UserData"

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        shared_pref = this.requireActivity().getSharedPreferences(USER_DATA, Context.MODE_PRIVATE)
        val user_fname = shared_pref.getString("user_first_name","ERROR [ProfilFragment] user first name")
        user_first_name.setText(user_fname)
        val user_lname = shared_pref.getString("user_last_name", "ERROR [ProfilFragment] user last name")
        user_last_name.setText(user_lname)
        val user_wrk = shared_pref.getString("user_workplace", "ERROR [ProfilFragment] user workspace")
        user_workplace.setText(user_wrk)

        btn_edit_user.setOnClickListener(){
            val intent = Intent(this.context, EditProfilActivity::class.java)
            startActivity(intent)
        }


    }

}