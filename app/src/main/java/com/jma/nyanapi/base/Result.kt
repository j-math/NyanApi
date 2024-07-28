package com.jma.nyanapi.base

sealed class Result<out T> {
    data class CodeStatus<out T>(val code: String) : Result<T>()
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Throwable) : Result<Nothing>()
}

val Result<*>.isSuccess
    get() = this is Result.Success

val <T> Result<T>.data get() = (this as Result.Success).data
val <T> Result<T>.code get() = (this as Result.CodeStatus).code
val <T> Result<T>.CodeStatus get() = (this as? Result.CodeStatus)
val <T> Result<T>.dataOrNull get() = (this as? Result.Success)?.data
val <T> Result<T>.error get() = (this as Result.Error).exception

fun <In, Out> Result<In>.map(mapper: (In) -> Out) =
    if (isSuccess) safeResult { mapper(data) }
    else Result.Error(error)

fun <Out> safeResult(block: () -> Out): Result<Out> =
    try {
        Result.Success(block())
    } catch (e: Throwable) {
        Result.Error(e)
    }

suspend fun <Out> getResult(block: suspend () -> Out): Result<Out> =
    try {
        Result.Success(block())
    } catch (e: Throwable) {
        Result.Error(e)
    }