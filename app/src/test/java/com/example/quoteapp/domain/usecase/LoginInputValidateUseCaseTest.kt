package com.example.quoteapp.domain.usecase

import com.example.quoteapp.data.model.LoginInputValidationType
import org.junit.Assert.assertEquals
import org.junit.Test

class LoginInputValidateUseCaseTest {

    private val loginInputValidateUseCase = LoginInputValidateUseCase()

    @Test
    fun `empty userName field return login validation type empty field`(){
        val result = loginInputValidateUseCase(userName = "", password = "password")
        assertEquals(LoginInputValidationType.EmptyField , result)
    }

    @Test
    fun `empty password field return login validation type empty field`(){
        val result = loginInputValidateUseCase(userName = "userName", password = "")
        assertEquals(LoginInputValidationType.EmptyField , result)
    }

    @Test
    fun `both userName and password fields are empty, return login validation type empty field`(){
        val result = loginInputValidateUseCase(userName = "", password = "")
        assertEquals(LoginInputValidationType.EmptyField , result)
    }

    @Test
    fun `both userName and password fields are non empty, return login validation type valid field`(){
        val result = loginInputValidateUseCase(userName = "userName", password = "password")
        assertEquals(LoginInputValidationType.Valid , result)
    }
}