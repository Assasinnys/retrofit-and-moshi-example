package com.example.myapplication.network.entity

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class UserRegistrationModel(
    val login: String,
    val email: String,
    val password: String
)

@JsonClass(generateAdapter = true)
data class UserCredWrapper(
    val user: UserRegistrationModel
)

@JsonClass(generateAdapter = true)
data class RegistrationResponse(
    @field:Json(name = "User-Token")
    val token: String,
    @field:Json(name = "login")
    val login: String,
    @field:Json(name = "password")
    val password: String
)

@JsonClass(generateAdapter = true)
data class UserLoginModel(
    val login: String,
    val password: String
)

@JsonClass(generateAdapter = true)
data class UserLoginWrapper(
    val user: UserLoginModel
)

@JsonClass(generateAdapter = true)
data class UserLoginResponse(
    @field:Json(name = "User-Token")
    val token: String?,
    @field:Json(name = "login")
    val login: String?,
    @field:Json(name = "error_code")
    val errorCode: Int?,
    @field:Json(name = "message")
    val message: String?
)
