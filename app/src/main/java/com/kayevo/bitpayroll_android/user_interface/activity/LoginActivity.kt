package com.kayevo.bitpayroll_android.user_interface.activity

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.kayevo.bitpayroll_android.application.Database
import com.kayevo.bitpayroll_android.databinding.ActivityLoginBinding
import com.kayevo.bitpayroll_android.model.Company
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

        setDatabase() // TODO remove it
    }

    fun setDatabase(){
        Database.companies.add(
            Company(
                "company@email.com",
                "password",
                mutableListOf("employee@email.com")
            )
        )
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
        if(view.editTextEmail.text.toString() != "company@email.com"){
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
            }else{
                showMessage("Incorrect login or don't have a company connection.")
            }
        }
    }

    private fun showMessage(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
    }

}