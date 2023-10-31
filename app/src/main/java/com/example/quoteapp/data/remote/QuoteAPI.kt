package com.example.quoteapp.data.remote

import com.example.quoteapp.data.model.Quotes
import retrofit2.Response
import retrofit2.http.GET

interface QuoteAPI {

    @GET("/quotes")
    suspend fun getQuotes(): Response<Quotes>
}