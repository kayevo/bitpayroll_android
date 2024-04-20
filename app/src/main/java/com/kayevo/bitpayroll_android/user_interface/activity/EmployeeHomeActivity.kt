package com.kayevo.bitpayroll_android.user_interface.activity

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.kayevo.bitpayroll_android.R
import com.kayevo.bitpayroll_android.databinding.ActivityCompanyHomeBinding
import com.kayevo.bitpayroll_android.databinding.ActivityEmployeeHomeBinding

class EmployeeHomeActivity : AppCompatActivity() {
    private lateinit var view: ActivityEmployeeHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityEmployeeHomeBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(view.root)
        setListeners()
    }

    private fun setListeners() {
        with(view) {
            buttonLogOut.setOnClickListener {
                finish()
            }
        }
    }
}