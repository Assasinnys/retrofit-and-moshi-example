package com.example.myapplication

import android.app.Application
import com.example.myapplication.domain.di.domainModule
import com.example.myapplication.network.di.networkModule
import com.example.myapplication.ui.di.uiModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@App)
            modules(networkModule, uiModule, domainModule)
        }
    }
}