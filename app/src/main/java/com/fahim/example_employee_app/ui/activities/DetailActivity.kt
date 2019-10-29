package com.fahim.example_employee_app.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fahim.example_employee_app.R
import com.fahim.example_employee_app.databinding.ActivityDetailBinding
import com.fahim.example_employee_app.utils.EmployeeKeys
import com.fahim.example_employee_app.viewmodels.DetailViewModel

class DetailActivity : AppCompatActivity() {

    lateinit var viewModel: DetailViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val binding: ActivityDetailBinding = DataBindingUtil.setContentView(
            this, R.layout.activity_detail)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        viewModel = ViewModelProviders.of(this).get(DetailViewModel::class.java)
        if (intent.hasExtra(EmployeeKeys.EMPLOYEE_ID)) {
            viewModel.getEmployee(intent.getIntExtra(EmployeeKeys.EMPLOYEE_ID, 0)).observe(this, Observer {
                binding.obj = it
            })
        }
    }


    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}