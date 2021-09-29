package com.example.myapplication.network.api

import com.example.myapplication.network.entity.*
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("/api/users")
    suspend fun createUser(@Body userCred: UserCredWrapper): RegistrationResponse

    @POST("/api/session")
    suspend fun loginUser(@Body userLoginModel: UserLoginWrapper): UserLoginResponse
}