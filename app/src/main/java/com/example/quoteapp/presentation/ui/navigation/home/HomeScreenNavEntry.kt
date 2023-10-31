package com.example.quoteapp.presentation.ui.navigation.home

import androidx.compose.runtime.collectAsState
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.example.quoteapp.presentation.ui.navigation.ScreenRoute
import com.example.quoteapp.presentation.ui.screens.home.HomeScreen
import com.example.quoteapp.presentation.viewmodel.home.HomeScreenViewModel

/**
 *  Job: Define home screen navigation entry.
 *  @author Ketan
 */
fun NavGraphBuilder.homeScreenNavEntry(
    navController: NavController
) {
    composable(
        route = ScreenRoute.HOME.route
    ) {
        val viewModel: HomeScreenViewModel = hiltViewModel()
        val homeScreenTO = viewModel.homeScreenTOStateFlow.collectAsState()
        HomeScreen(
            homeScreenTO = homeScreenTO.value
        )
    }
}