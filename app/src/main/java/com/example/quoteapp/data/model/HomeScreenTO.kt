package com.example.quoteapp.data.model

import java.io.Serializable

sealed class HomeScreenTO : Serializable {

    object Loading: HomeScreenTO()

    data class Success(var result: List<Result>): HomeScreenTO()

    object Error: HomeScreenTO()
}
