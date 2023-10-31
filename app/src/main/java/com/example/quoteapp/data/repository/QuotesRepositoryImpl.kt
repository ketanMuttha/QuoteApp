package com.example.quoteapp.data.repository

import com.example.quoteapp.data.model.Quotes
import com.example.quoteapp.data.remote.QuoteAPI
import com.example.quoteapp.domain.repository.QuotesRepository
import retrofit2.Response
import javax.inject.Inject

class QuotesRepositoryImpl @Inject constructor(private val quoteAPI: QuoteAPI) : QuotesRepository {

    override suspend fun getQuotes(): Response<Quotes> {
      return quoteAPI.getQuotes()
    }
}