package com.example.quoteapp.data.repository

import com.example.quoteapp.domain.repository.LoginRepository
import kotlinx.coroutines.delay

class LoginRepositoryImpl: LoginRepository {

    override suspend fun login(email: String, password: String): Boolean {
        delay(1500) // This will replicate an authorization service call.
        return true
    }
}