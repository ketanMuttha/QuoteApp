package com.example.quoteapp.domain.repository

import com.example.quoteapp.data.model.Quotes
import retrofit2.Response

interface QuotesRepository {

    suspend fun getQuotes(): Response<Quotes>
}