package com.example.quoteapp.domain.usecase

import com.example.quoteapp.data.model.LoginInputValidationType


class LoginInputValidateUseCase() {

    operator fun invoke(userName: String, password: String): LoginInputValidationType {
        if(userName.isEmpty() || password.isEmpty()){
            return LoginInputValidationType.EmptyField
        }
        return LoginInputValidationType.Valid
    }
}