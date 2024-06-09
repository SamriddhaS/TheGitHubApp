package com.dheeraj.jetpackpractise.data.remote.api

import android.content.Context
import com.example.thegithubapp.utils.CheckInternet
import com.example.thegithubapp.utils.NoInternetException
import okhttp3.Interceptor
import okhttp3.Response

class ConnectivityInterceptor(private val context:Context):Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        if (!CheckInternet.isOnline(context = context)) throw NoInternetException("Internet Not Available")
        return chain.proceed(chain.request())
    }
}