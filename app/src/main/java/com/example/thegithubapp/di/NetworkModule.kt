package com.example.thegithubapp.di

import android.content.Context
import com.dheeraj.jetpackpractise.data.remote.api.ConnectivityInterceptor
import com.example.thegithubapp.utils.Constants.BASE_URL
import com.example.thegithubapp.data.network.APIs
import com.example.thegithubapp.data.network.AuthInterceptor
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Singleton
    @Provides
    fun providesRetrofit(client: OkHttpClient): Retrofit{
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .client(client)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Singleton
    @Provides
    fun providesAPIs(retrofit: Retrofit): APIs {
        return retrofit.create(APIs::class.java)
    }

    @Singleton
    @Provides
    fun providesLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
    }


    @Singleton
    @Provides
    fun providesOkHttpClient(
        @ApplicationContext context: Context,
        authInterceptor: AuthInterceptor,
        loggingInterceptor: HttpLoggingInterceptor): OkHttpClient{
        return OkHttpClient.Builder()
            .connectTimeout(5000, TimeUnit.SECONDS)
            .readTimeout(500, TimeUnit.SECONDS)
            .addInterceptor(ConnectivityInterceptor(context))
            .addInterceptor(authInterceptor)
            .addInterceptor(loggingInterceptor)
            .writeTimeout(500, TimeUnit.SECONDS)
            .build()
    }

}