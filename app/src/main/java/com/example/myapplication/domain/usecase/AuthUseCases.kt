package com.example.myapplication.domain.usecase

import com.example.myapplication.domain.repository.AuthRepository
import com.example.myapplication.network.entity.RegistrationResponse
import com.example.myapplication.network.entity.UserLoginModel
import com.example.myapplication.network.entity.UserLoginResponse
import com.example.myapplication.network.entity.UserRegistrationModel

class RegistrationUseCase(
    private val authRepo: AuthRepository
) : BaseUseCase<RegistrationResponse, UserRegistrationModel>() {

    override suspend fun run(params: UserRegistrationModel): RegistrationResponse {
        return authRepo.createUser(params)
    }
}

class LoginUseCase(
    private val authRepo: AuthRepository
) : BaseUseCase<UserLoginResponse, UserLoginModel>() {

    override suspend fun run(params: UserLoginModel): UserLoginResponse {
        return authRepo.loginUser(params)
    }
}