package com.kayevo.bitpayroll_android.user_interface.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kayevo.bitpayroll_android.R
import com.kayevo.bitpayroll_android.databinding.ActivityCompanyEmployeesBinding
import com.kayevo.bitpayroll_android.databinding.ActivityCompanyHomeBinding

class CompanyHomeActivity : AppCompatActivity() {
    private lateinit var view: ActivityCompanyHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityCompanyHomeBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(view.root)
        setListeners()
    }

    private fun setListeners() {
        with(view) {
            buttonEmployees.setOnClickListener {
                goToEmployees()
            }
            buttonLogOut.setOnClickListener {
                finish()
            }
        }
    }

    private fun goToEmployees() {
        val intent = Intent(this, CompanyEmployeesActivity::class.java)
        startActivity(intent)
    }
}