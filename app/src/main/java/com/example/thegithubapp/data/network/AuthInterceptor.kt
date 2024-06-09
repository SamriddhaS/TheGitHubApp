package com.example.thegithubapp.data.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class AuthInterceptor @Inject constructor(): Interceptor  {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
            .newBuilder()
            .addHeader("accept", "application/json")
            //.addHeader("Authorization", "Bearer $TOKEN")
            .build()
        return chain.proceed(request)
    }
}