package com.example.quoteapp.domain.repository

interface LoginRepository {

    suspend fun login(userName: String, password:String):Boolean

}