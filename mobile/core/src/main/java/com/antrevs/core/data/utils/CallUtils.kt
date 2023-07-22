package com.antrevs.core.data.utils

import com.antrevs.core.data.entity.ApiErrorResponseException
import com.antrevs.core.data.entity.UnauthorizedException
import com.antrevs.core.network.HttpErrorCode
import com.antrevs.model.base.BaseResponseModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import java.lang.Exception

suspend fun <T: BaseResponseModel> apiRequest(
    call: suspend () -> T,
): T = withContext(Dispatchers.IO) {
    val callResult: T
    try {
        callResult = call()
    } catch (e: HttpException) {
        when (e.code()) {
            HttpErrorCode.UNAUTHORIZED -> throw UnauthorizedException()
            else -> throw e
        }
    }
    callResult.error?.let {
        throw ApiErrorResponseException(it.errorCode)
    }
    callResult
}
