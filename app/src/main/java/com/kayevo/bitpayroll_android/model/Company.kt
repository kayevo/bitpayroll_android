package com.kayevo.bitpayroll_android.model

data class Company(
    val email: String,
    val password: String,
    val connectedEmployeeEmails: MutableList<String>,
)
