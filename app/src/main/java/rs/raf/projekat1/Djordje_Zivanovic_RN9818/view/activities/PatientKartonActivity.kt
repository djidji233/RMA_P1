package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.activities

import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_karton.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.model.Patient
import java.text.SimpleDateFormat

class PatientKartonActivity() : AppCompatActivity() {

    private fun fillInData(p : Patient){
        patient_first_name.setText(p.first_name)
        patient_last_name.setText(p.last_name)
        patient_symptoms_old.setText(p.symptoms)
        patient_symptoms_new.setText(p.symptoms)

        val datePattern = "dd.MM.yyyy"
        val dateFormat = SimpleDateFormat(datePattern)
        patient_acceptance_date.text = dateFormat.format(p.acceptance_date)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_karton)

//        fillInData(patient)

        btn_edit_patient_cancel.setOnClickListener(){
            finish()
        }

        btn_edit_patient_change.setOnClickListener(){
            Toast.makeText(applicationContext,"Please fill in all the fields!", Toast.LENGTH_SHORT).show()
        }

    }


}