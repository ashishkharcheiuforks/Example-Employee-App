package com.fahim.example_employee_app.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.fahim.example_employee_app.R
import com.fahim.example_employee_app.viewmodels.AddRemoveViewModel

class AddRemoveFragment : Fragment() {

    private lateinit var addRemoveViewModel: AddRemoveViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        addRemoveViewModel =
            ViewModelProviders.of(this).get(AddRemoveViewModel::class.java)
        val root = inflater.inflate(R.layout.fragment_add_remove, container, false)
        return root
    }
}