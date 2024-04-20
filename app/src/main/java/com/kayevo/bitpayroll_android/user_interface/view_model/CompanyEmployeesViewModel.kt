package com.kayevo.bitpayroll_android.user_interface.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kayevo.bitpayroll_android.application.Database
import kotlinx.coroutines.launch

class CompanyEmployeesViewModel(): ViewModel() {
    private val _isEmployeeConnected = MutableLiveData<Boolean>()
    val isEmployeeConnected: LiveData<Boolean> get() = _isEmployeeConnected

    fun connectEmployee(companyEmail: String, employeeEmail: String) {
        viewModelScope.launch {
            Database.companies.find {
                it.email == companyEmail
            }?.connectedEmployeeEmails?.add(employeeEmail)

            _isEmployeeConnected.postValue(true);
        }
    }
}