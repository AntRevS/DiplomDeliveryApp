package com.antrevs.core.network.interceptor

import com.antrevs.core.data.storage.UserInfoStorage
import com.antrevs.core.network.HttpHeaders
import okhttp3.Interceptor
import okhttp3.Response

internal class SessionInterceptor(
    private val userInfoStorage: UserInfoStorage,
): Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val requestBuilder = chain.request().newBuilder()
        val sessionId = userInfoStorage.getSession()
        sessionId?.let {
            requestBuilder.header(HttpHeaders.SESSION_ID, it)
        }
        return chain.proceed(requestBuilder.build())
    }
}
