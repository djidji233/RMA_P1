package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments


import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import kotlinx.android.synthetic.main.fragment_unos.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.viewmodels.MainViewModel

class UnosFragment : Fragment(R.layout.fragment_unos){

    private val mainViewModel : MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    fun init(){
        initListeners()
    }

    fun initListeners(){
        btn_add_patient.setOnClickListener(){
            val name = patient_first_name.text.toString()
            val lname = patient_last_name.text.toString()
            val sympt = patient_symptoms.text.toString()
            if(name.isNotBlank() && lname.isNotBlank() && sympt.isNotBlank()){
                mainViewModel.addWaitingPatient(name,lname,sympt)
                patient_first_name.text.clear()
                patient_last_name.text.clear()
                patient_symptoms.text.clear()
                Toast.makeText(this.activity,"Patient successfully added",Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this.activity,"Please fill in all the fields!",Toast.LENGTH_SHORT).show()
            }
        }
    }

}