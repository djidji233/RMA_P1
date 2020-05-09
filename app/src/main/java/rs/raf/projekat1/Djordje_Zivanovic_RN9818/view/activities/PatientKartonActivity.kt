package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.activities

import android.app.Activity
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_karton.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.model.Patient
import java.text.SimpleDateFormat

class PatientKartonActivity : AppCompatActivity() {

    private lateinit var patient : Patient
    private lateinit var patient_updated : Patient

    private fun fillInData(p : Patient){
        patient_first_name.setText(p.first_name)
        patient_last_name.setText(p.last_name)
        patient_symptoms_old.setText(p.symptoms)
        patient_symptoms_new.setText(p.current_symptoms)

        val datePattern = "dd.MM.yyyy"
        val dateFormat = SimpleDateFormat(datePattern)
        patient_acceptance_date.text = dateFormat.format(p.acceptance_date)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_karton)

        patient = intent.getParcelableExtra("patient") as Patient
        fillInData(patient)
        patient_updated = patient.copy()

        btn_edit_patient_cancel.setOnClickListener{
            setResult(Activity.RESULT_CANCELED)
            finish()
        }

        btn_edit_patient_change.setOnClickListener{
            if(patient_first_name.text.isNotBlank()&&patient_last_name.text.isNotBlank()
                &&patient_symptoms_old.text.isNotBlank()&&patient_symptoms_new.text.isNotBlank()){

                patient_updated.first_name = patient_first_name.text.toString()
                patient_updated.last_name = patient_last_name.text.toString()
                patient_updated.symptoms = patient_symptoms_old.text.toString()
                patient_updated.current_symptoms = patient_symptoms_new.text.toString()

                intent.putExtra("patient", patient)
                intent.putExtra("patient_updated", patient_updated)

                setResult(Activity.RESULT_OK,intent)
                finish()

            } else {
                Toast.makeText(this,"Please fill in all the fields",Toast.LENGTH_SHORT).show()
            }
        }

    }


}