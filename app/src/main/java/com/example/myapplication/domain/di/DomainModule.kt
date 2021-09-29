package com.example.myapplication.domain.di

import com.example.myapplication.domain.repository.AuthRepository
import com.example.myapplication.domain.usecase.LoginUseCase
import com.example.myapplication.domain.usecase.RegistrationUseCase
import org.koin.dsl.module

val domainModule = module {
    single {
        AuthRepository(get())
    }

    single {
        RegistrationUseCase(get())
    }

    single {
        LoginUseCase(get())
    }
}