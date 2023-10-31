package com.example.quoteapp.presentation.di

import com.example.quoteapp.constant.Constants
import com.example.quoteapp.data.remote.QuoteAPI
import com.example.quoteapp.data.repository.LoginRepositoryImpl
import com.example.quoteapp.data.repository.QuotesRepositoryImpl
import com.example.quoteapp.domain.repository.LoginRepository
import com.example.quoteapp.domain.repository.QuotesRepository
import com.example.quoteapp.domain.usecase.LoginInputValidateUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class AppModule {

    @Provides
    @Singleton
    fun providesRetrofit(): Retrofit {
        return Retrofit
            .Builder()
            .baseUrl(Constants.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun providesQuoteAPI(retrofit: Retrofit): QuoteAPI {
        return retrofit.create(QuoteAPI::class.java)
    }

    @Provides
    @Singleton
    fun providesQuotesRepository(quoteAPI: QuoteAPI): QuotesRepository {
        return QuotesRepositoryImpl(quoteAPI)
    }

    @Provides
    @Singleton
    fun provideLoginInputValidateUseCase(): LoginInputValidateUseCase {
        return LoginInputValidateUseCase()
    }

    @Provides
    @Singleton
    fun providesLoginRepository(): LoginRepository {
        return LoginRepositoryImpl()
    }
}