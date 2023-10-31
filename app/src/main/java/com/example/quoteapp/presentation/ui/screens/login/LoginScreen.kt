package com.example.quoteapp.presentation.ui.screens.login

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.example.quoteapp.R
import com.example.quoteapp.data.model.LoginState
import com.example.quoteapp.presentation.ui.components.ButtonComponent
import com.example.quoteapp.presentation.ui.components.HeadingTextComponent
import com.example.quoteapp.presentation.ui.components.Loader
import com.example.quoteapp.presentation.ui.components.MyPasswordTextField
import com.example.quoteapp.presentation.ui.components.QuotesTextField
import com.example.quoteapp.presentation.ui.components.NormalTextComponent
import com.example.quoteapp.presentation.ui.components.UnderLinesText
import com.example.quoteapp.presentation.ui.navigation.NavigationHelper

/**
 *  Job: To show a login screen.
 *  @author Ketan
 */
private val TAG = "LoginScreen"
@Composable
fun LoginScreen(
    loginState: LoginState,
    userNameValue: () -> String,
    passwordValue: () -> String,
    buttonEnabled: () -> Boolean,
    onUserNameChanged: (String) -> Unit,
    onPasswordChanged: (String) -> Unit,
    onSingInClick: () -> Unit,
    onLoginSuccess: () -> Unit,
) {

    NavigationHelper(
        shouldNavigate = {
            loginState.isSuccessfullyLoggedIn
        },
        destination = {
            onLoginSuccess()
        }
    )

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            if (loginState.isLoading) {
                Loader()
            } else {
                Spacer(modifier = Modifier.height(40.dp))
                NormalTextComponent(
                    value = stringResource(id = R.string.login_screen_title),
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight(Alignment.Top)
                )
                HeadingTextComponent(
                    value = stringResource(id = R.string.login_screen_login),
                    modifier = Modifier
                        .fillMaxWidth()
                )
                Spacer(modifier = Modifier.height(20.dp))
                QuotesTextField(
                    labelValue = stringResource(id = R.string.login_screen_user_name),
                    textValue = userNameValue(),
                    onValueChanged = onUserNameChanged
                )
                Spacer(modifier = Modifier.height(20.dp))
                MyPasswordTextField(
                    labelValue = stringResource(id = R.string.login_screen_password),
                    textValue = passwordValue(),
                    onValueChanged = onPasswordChanged
                )
                Spacer(modifier = Modifier.height(20.dp))
                ButtonComponent(
                    value = stringResource(id = R.string.login_screen_sign_in),
                    enabled = buttonEnabled(),
                ) {
                    onSingInClick()
                }
                Spacer(modifier = Modifier.height(20.dp))
                UnderLinesText("Forgot your password")
            }
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview() {
    val navController = rememberNavController()
    // LoginScreen(navController)
}