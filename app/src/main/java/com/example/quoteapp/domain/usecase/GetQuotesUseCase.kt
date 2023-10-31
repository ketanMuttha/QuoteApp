package com.example.quoteapp.domain.usecase

import com.example.quoteapp.data.model.Quotes
import com.example.quoteapp.domain.repository.QuotesRepository
import retrofit2.Response
import javax.inject.Inject

/**
 * Job: Serve as a use case for QuotesRepository.
 *
 * @author Ketan
 */
class GetQuotesUseCase @Inject constructor(private val quotesRepository: QuotesRepository){

    suspend operator fun invoke(): Response<Quotes> {
        return quotesRepository.getQuotes()
    }
}