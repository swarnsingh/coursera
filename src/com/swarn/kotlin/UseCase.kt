package com.swarn.kotlin

import kotlinx.coroutines.flow.*

sealed class UseCaseResourceStatus<T>(open val data: T?) {
    class Success<T>(override val data: T) : UseCaseResourceStatus<T>(data)
    class Loading<T>(override val data: T? = null) : UseCaseResourceStatus<T>(data)
    class Error<T>(override val data: T? = null, val throwable: Throwable) : UseCaseResourceStatus<T>(data)
}

suspend fun <T : UseCaseResourceStatus<*>?> Flow<T>.collectUntilSuccessOrError(collector: FlowCollector<T>? = null) {
    transformWhile {
        emit(it)
        it !is UseCaseResourceStatus.Success<*> && it !is UseCaseResourceStatus.Error<*>
    }.collect {
        collector?.emit(it)
    }
}

suspend fun <T> handleNetworkResponse(
    flow: Flow<UseCaseResourceStatus<T>?>,
    onLoading: ((UseCaseResourceStatus.Loading<T>) -> Unit)? = null,
    onSuccess: ((UseCaseResourceStatus.Success<T>) -> Unit)? = null,
    onError: ((UseCaseResourceStatus.Error<T>) -> Unit)? = null,
) {
    flow.collectUntilSuccessOrError { status ->
        when (status) {
            is UseCaseResourceStatus.Error -> {
                onError?.invoke(status)
            }

            is UseCaseResourceStatus.Loading -> {
                onLoading?.invoke(status)
            }

            is UseCaseResourceStatus.Success -> {
                onSuccess?.invoke(status)
            }

            else -> {}
        }
    }
}
