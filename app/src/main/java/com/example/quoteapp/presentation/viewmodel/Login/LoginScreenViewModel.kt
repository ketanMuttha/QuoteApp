package com.example.quoteapp.presentation.viewmodel.Login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quoteapp.data.model.LoginInputValidationType
import com.example.quoteapp.data.model.LoginState
import com.example.quoteapp.domain.usecase.LoginInputUseCase
import com.example.quoteapp.domain.usecase.LoginInputValidateUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *  Job: define a view model for LoginScreen.
 *  @author Ketan
 */
@HiltViewModel
class LoginScreenViewModel @Inject constructor(
    private val loginInputUseCase: LoginInputUseCase,
    private val loginInputValidateUseCase: LoginInputValidateUseCase
) : ViewModel() {

    var loginState by mutableStateOf(LoginState())
        private set

    fun onUserNameInputChange(newValue: String) {
        loginState = loginState.copy(userNameInput = newValue)
        checkInputValidation()
    }

    fun onPasswordInputChange(newValue: String) {
        loginState = loginState.copy(passwordInput = newValue)
        checkInputValidation()
    }

    fun onSingInClick() {
        loginState = loginState.copy(isLoading = true)
        viewModelScope.launch {
            loginState = try {
                val loginResult = loginInputUseCase(
                    userName = loginState.userNameInput,
                    password = loginState.passwordInput
                )
                loginState.copy(isSuccessfullyLoggedIn = true)
            } catch (e: Exception) {
                loginState.copy(isLoading = false)
            } finally {
                loginState = loginState.copy(isLoading = false)
            }
        }
    }

    private fun checkInputValidation() {
        val validationResult = loginInputValidateUseCase(
            loginState.userNameInput,
            loginState.passwordInput
        )
        processInputValidationType(validationResult)
    }

    private fun processInputValidationType(type: LoginInputValidationType) {
        loginState = when (type) {
            LoginInputValidationType.EmptyField -> {
                loginState.copy(isInputValid = false)
            }

            LoginInputValidationType.Valid -> {
                loginState.copy(isInputValid = true)
            }
        }
    }
}