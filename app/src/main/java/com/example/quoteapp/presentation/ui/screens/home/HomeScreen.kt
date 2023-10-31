package com.example.quoteapp.presentation.ui.screens.home

import android.widget.Toast
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import com.example.quoteapp.R
import com.example.quoteapp.data.model.HomeScreenTO
import com.example.quoteapp.presentation.ui.components.Loader
import com.example.quoteapp.data.model.Result
import com.example.quoteapp.presentation.ui.components.HomeScreenCard

/**
 *  Job: Show quotes list.
 *  @author Ketan
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    homeScreenTO: HomeScreenTO
) {
    val context = LocalContext.current
    val errorMessage = stringResource(id = R.string.home_screen_quote_service_error)
    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
                 TopAppBar(
                     title = { Text(text = stringResource(id = R.string.home_screen_title)) }
                 )
        },

    ) {
        Box(modifier = Modifier.padding(it)){
         when(homeScreenTO) {
             is HomeScreenTO.Loading -> {
                 Loader()
             }
             is HomeScreenTO.Success -> {
                 val quotes = homeScreenTO.result
                 showQuotesList(quotes)
             }
             is HomeScreenTO.Error -> {
                Toast.makeText(context, errorMessage, Toast.LENGTH_LONG).show()
             }
         }
        }
    }
}

@Composable
private fun showQuotesList(quotes: List<Result>) {
    LazyColumn(

    ) {
        items(quotes) { quote ->
            HomeScreenCard(
                content = quote.content,
                author = stringResource(id = R.string.home_Screen_card_item_author, quote.author)
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun HomeScreenPreview(){
    val quotes = mutableListOf<Result>()
    val result = Result(
        quoteId = 1,
        author = "Thomas Edison",
        content = "I never did a day's work in my life.  It was all fun.",
    )
    quotes.add(result)
    val homeScreenTO = HomeScreenTO.Success(quotes)
    HomeScreen(homeScreenTO = homeScreenTO)
}