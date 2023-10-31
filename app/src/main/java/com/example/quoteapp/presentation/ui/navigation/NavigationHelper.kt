package com.example.quoteapp.presentation.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect

/**
 *  Job: This is a helper composable to navigate between different screen.
 *  @author Ketan
 */
@Composable
fun NavigationHelper(
    shouldNavigate:()->Boolean,
    destination:()->Unit
) {
    LaunchedEffect(key1 = shouldNavigate()){
        if(shouldNavigate()){
            destination()
        }
    }
}