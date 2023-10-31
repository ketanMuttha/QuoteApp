package com.example.quoteapp.presentation.viewmodel.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quoteapp.data.model.HomeScreenTO
import com.example.quoteapp.domain.usecase.GetQuotesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 *  Job: define a view model for HomeScreen.
 *  @author Ketan
 */
@HiltViewModel
class HomeScreenViewModel @Inject constructor(private val getQuotesUseCase: GetQuotesUseCase) : ViewModel() {

    private var _homeScreenTOMutableStateFlow = MutableStateFlow<HomeScreenTO>(HomeScreenTO.Loading)

    val homeScreenTOStateFlow: StateFlow<HomeScreenTO>
        get() = _homeScreenTOMutableStateFlow

    init {
        getQuotes()
    }

    private fun getQuotes() {
        viewModelScope.launch {
            val response = getQuotesUseCase()
            if (response.isSuccessful) {
                val quotes = response.body()
                if (quotes != null && quotes.results.isNotEmpty()) {
                    _homeScreenTOMutableStateFlow.value = HomeScreenTO.Success(quotes.results)
                } else {
                    _homeScreenTOMutableStateFlow.value = HomeScreenTO.Error
                }
            } else {
                _homeScreenTOMutableStateFlow.value = HomeScreenTO.Error
            }
        }
    }
}