package com.kayevo.bitpayroll_android.user_interface.activity

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kayevo.bitpayroll_android.databinding.ActivityCompanyEmployeesBinding
import com.kayevo.bitpayroll_android.user_interface.view_model.CompanyEmployeesViewModel

class CompanyEmployeesActivity : AppCompatActivity() {

    private lateinit var view: ActivityCompanyEmployeesBinding
    private lateinit var viewModel: CompanyEmployeesViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityCompanyEmployeesBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(view.root)
        viewModel = ViewModelProvider(this).get(CompanyEmployeesViewModel::class.java)
        setListeners()
        setObservers()
    }

    private fun setListeners() {
        with(view) {
            buttonConnectEmployee.setOnClickListener {
                val companyEmail = "company@email.com"
                viewModel.connectEmployee(
                    companyEmail, view.editTextEmail.text.toString()
                )
            }
            buttonBack.setOnClickListener {
                finish()
            }
        }
    }

    private fun setObservers() {
        viewModel.isEmployeeConnected.observe(this) { result ->
            if(result){
                showMessage("Employee connected")
            }
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }
}