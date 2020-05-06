package rs.raf.projekat1.Djordje_Zivanovic_RN9818.view.fragments

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import kotlinx.android.synthetic.main.fragment_stanje.*
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.R
import rs.raf.projekat1.Djordje_Zivanovic_RN9818.viewmodels.MainViewModel

class StanjeFragment : Fragment(R.layout.fragment_stanje){

    private val mainViewModel : MainViewModel by activityViewModels()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init(){
        initObservers()
    }

    private fun initObservers(){
        mainViewModel.getWaitingPatients().observe(viewLifecycleOwner, Observer {
            pacijenti_cekaonicaTv.text = mainViewModel.getListSize(0).toString()
        })
        mainViewModel.getHospitalizedPatients().observe(viewLifecycleOwner, Observer {
            pacijenti_hospitalizovaniTv.text = mainViewModel.getListSize(1).toString()
        })
        mainViewModel.getReleasedPatients().observe(viewLifecycleOwner, Observer {
            pacijenti_otpusteniTv.text = mainViewModel.getListSize(2).toString()
        })
    }


}