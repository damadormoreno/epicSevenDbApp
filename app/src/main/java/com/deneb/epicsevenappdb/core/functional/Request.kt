package com.deneb.epicsevenappdb.core.functional

import com.deneb.epicsevenappdb.core.exception.Failure
import retrofit2.Call

fun <T, R> request(
    call: Call<T>,
    transform: (T) -> R,
    default: T
): Either<Failure, R> {
    return try {
        val response = call.execute()
        when (response.isSuccessful) {
            true -> Either.Right(transform((response.body() ?: default)))
            false -> Either.Left(Failure.CustomError(response.code(), response.message()))
        }
    } catch (exception: Throwable) {
        Either.Left(Failure.CustomError(exception.stackTrace.hashCode(), exception.localizedMessage))
    }
}