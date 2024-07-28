package com.jma.nyanapi.base

import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

abstract class BaseServiceUseCase <in Params, out Results>(
    private val coroutineDispatcher: CoroutineDispatcher,
) {

    suspend operator fun invoke(parameters: Params): Result<Results> {
        return try {
            withContext(coroutineDispatcher) {
                try {
                    execute(parameters)
                } catch (e: Exception) {
                    e.printStackTrace()
                    Result.Error(e)
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            Result.Error(e)
        }
    }

    @Throws(RuntimeException::class)
    protected abstract suspend fun execute(parameters: Params): Result<Results>
}