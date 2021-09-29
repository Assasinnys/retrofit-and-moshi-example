package com.example.myapplication.network.di

import com.example.myapplication.network.BASE_URL
import com.example.myapplication.network.api.AuthApi
import com.example.myapplication.network.interceptor.AuthTokenInterceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

val networkModule = module {

    single {
        OkHttpClient.Builder()
            .addInterceptor(AuthTokenInterceptor())
            .addInterceptor(HttpLoggingInterceptor().apply { setLevel(HttpLoggingInterceptor.Level.BODY) })
            .build()
    }

    single {
        Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(get())
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    single {
        get<Retrofit>().create<AuthApi>()
    }
}
