package com.example.myapplication.domain.usecase

import kotlinx.coroutines.flow.flow

abstract class BaseUseCase<out Type, in Params> where Type : Any {

    abstract suspend fun run(params: Params): Type

    fun execute(params: Params) = flow<Type> {
        emit(run(params))
    }
}

object EmptyParams