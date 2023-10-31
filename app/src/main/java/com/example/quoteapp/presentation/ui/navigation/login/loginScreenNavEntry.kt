package com.example.quoteapp.presentation.ui.navigation.login

import androidx.compose.ui.platform.LocalFocusManager
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.quoteapp.presentation.ui.navigation.ScreenRoute
import com.example.quoteapp.presentation.ui.screens.login.LoginScreen
import com.example.quoteapp.presentation.viewmodel.Login.LoginScreenViewModel

/**
 *  Job: Define login screen navigation entry.
 *  @author Ketan
 */
fun NavGraphBuilder.loginScreenNavEntry(
    navController: NavController
) {
    composable(route = ScreenRoute.LOGIN.route) {
        val viewModel: LoginScreenViewModel = hiltViewModel()
        val loginState = viewModel.loginState
        val focusManager = LocalFocusManager.current
        LoginScreen(
            loginState = loginState,
            userNameValue = { viewModel.loginState.userNameInput },
            passwordValue = { viewModel.loginState.passwordInput },
            onUserNameChanged = viewModel::onUserNameInputChange,
            onPasswordChanged = viewModel::onPasswordInputChange,
            buttonEnabled = { viewModel.loginState.isInputValid },
            onSingInClick = {
                focusManager.clearFocus() // hide keyboard
                viewModel.onSingInClick()
            },
            onLoginSuccess = {
                navController.navigate(ScreenRoute.HOME.route) {
                    popUpTo(0) // remove login screen from stack.
                }
            }
        )
    }
}