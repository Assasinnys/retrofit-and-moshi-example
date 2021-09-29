package com.example.myapplication.ui.main

import android.util.Log
import androidx.databinding.ObservableField
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapplication.domain.usecase.LoginUseCase
import com.example.myapplication.network.entity.UserLoginModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class MainViewModel(
    private val loginUseCase: LoginUseCase
) : ViewModel() {

    val username = ObservableField<String>()
    val password = ObservableField<String>()

    fun onLoginButtonClick() {
        if (username.get().isNullOrEmpty() || password.get().isNullOrEmpty()) return

        val loginModel = UserLoginModel(
            login = username.get() ?: "",
            password = password.get() ?: ""
        )

        loginUseCase.execute(loginModel)
            .onEach {
                Log.d(MainViewModel::class.simpleName, "response: $it")
            }
            .catch { Log.e("ERROR", "Can't log in", it) }
            .launchIn(viewModelScope)
    }
}