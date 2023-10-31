package com.example.quoteapp.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.example.quoteapp.presentation.ui.navigation.login.loginScreenNavEntry
import com.example.quoteapp.presentation.ui.navigation.home.homeScreenNavEntry

/**
 *  Job: Define navigation host entries.
 *  @author Ketan
 */
@Composable
fun QuotesScreenNavHost(
    startDestination: ScreenRoute = ScreenRoute.LOGIN
) {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = startDestination.route){
        loginScreenNavEntry(navController)
        homeScreenNavEntry(navController)
    }
}