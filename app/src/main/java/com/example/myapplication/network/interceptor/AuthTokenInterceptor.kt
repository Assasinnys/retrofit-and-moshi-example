package com.example.myapplication.network.interceptor

import com.example.myapplication.network.APP_TOKEN
import okhttp3.Interceptor
import okhttp3.Response

class AuthTokenInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request =
            chain.request()
                .newBuilder()
                .addHeader("Authorization", "Token token=$APP_TOKEN")
                .build()
        return chain.proceed(request)
    }
}