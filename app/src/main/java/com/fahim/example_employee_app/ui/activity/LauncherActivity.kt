package com.fahim.example_employee_app.ui.activity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.fahim.example_employee_app.EmployeeApplication
import com.fahim.example_employee_app.R
import com.fahim.example_employee_app.viewmodel.LauncherViewModel
import dagger.android.support.DaggerAppCompatActivity
import javax.inject.Inject


class LauncherActivity : DaggerAppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private val viewModel : LauncherViewModel by viewModels {
        viewModelFactory
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        supportActionBar?.hide()
        //viewModel = ViewModelProviders.of(this,viewModelFactory).get(LauncherViewModel::class.java)
        //viewModel = createViewModel { (application as EmployeeApplication).component.provideMainViewModel() }
        //viewModel.checkExistingData()
        viewModel.addLifeCycleObserver(lifecycle)

        handleLiveData()
    }

    private fun handleLiveData(){
        viewModel.navigateToTabActivityLD.observe(this, Observer {
            it?.let {
                if(it)
                    startActivity(Intent(this,TabPageActivity::class.java))
                    finish()
            } })
    }

}
