package com.example.myapplication.domain.repository

import com.example.myapplication.network.api.AuthApi
import com.example.myapplication.network.entity.*

class AuthRepository(private val authApi: AuthApi) {

    suspend fun createUser(userRegistrationModel: UserRegistrationModel): RegistrationResponse {
        return authApi.createUser(UserCredWrapper(userRegistrationModel))
    }

    suspend fun loginUser(userLoginModel: UserLoginModel): UserLoginResponse {
        return authApi.loginUser(UserLoginWrapper(userLoginModel))
    }
}