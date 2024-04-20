package com.kayevo.bitpayroll_android.user_interface.view_model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class LoginViewModel(): ViewModel() {
    private val _isLoggedIn = MutableLiveData<Boolean>()
    val isLoggedIn: LiveData<Boolean> get() = _isLoggedIn

    fun login(email: String, password: String) {
        viewModelScope.launch {
            _isLoggedIn.postValue(true);
        }
    }
}