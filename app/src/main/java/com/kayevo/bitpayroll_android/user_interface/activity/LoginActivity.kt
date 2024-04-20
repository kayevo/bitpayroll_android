package com.kayevo.bitpayroll_android.user_interface.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kayevo.bitpayroll_android.databinding.ActivityLoginBinding
import com.kayevo.bitpayroll_android.user_interface.view_model.LoginViewModel

class LoginActivity : AppCompatActivity() {
    private lateinit var view: ActivityLoginBinding
    private lateinit var viewModel: LoginViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        view = ActivityLoginBinding.inflate(layoutInflater)
        enableEdgeToEdge()
        setContentView(view.root)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java)
        setListeners()
        setObservers()
    }

    private fun setListeners() {
        with(view) {
            buttonLogin.setOnClickListener {
                // call viewmodel
                viewModel.login(
                    view.editTextEmail.text.toString(), view.editTextPassword.text.toString()
                )
            }
            buttonSignUp.setOnClickListener {
                // go to sign up
            }
        }
    }

    private fun goToHome() {
        if(view.editTextEmail.text.toString() == "employee"){
            val intent = Intent(this, EmployeeHomeActivity::class.java)
            startActivity(intent)
        }else{
            val intent = Intent(this, CompanyHomeActivity::class.java)
            startActivity(intent)
        }
    }

    private fun setObservers() {
        viewModel.isLoggedIn.observe(this) { result ->
            if(result){
                goToHome()
            }
        }
    }

}