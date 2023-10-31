package com.example.quoteapp.domain.usecase

import com.example.quoteapp.domain.repository.LoginRepository
import javax.inject.Inject

class LoginInputUseCase @Inject constructor(private val loginRepository: LoginRepository){

    suspend operator fun invoke(userName: String, password:String): Boolean {
       return loginRepository.login(userName, password)
    }
}