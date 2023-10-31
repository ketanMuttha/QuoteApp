package com.example.quoteapp.data.model

data class LoginState(
    val userNameInput:String = "",
    val passwordInput:String = "",
    val isInputValid:Boolean = false,
    val isPasswordShown:Boolean = false,
    val isLoading:Boolean = false,
    val isSuccessfullyLoggedIn:Boolean = false,
)