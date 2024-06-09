package com.example.thegithubapp.di

import com.example.thegithubapp.data.network.APIs
import com.example.thegithubapp.data.repo.HomeRepository
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
object RepositoryModule {

    fun provideHomeRepository(
        moviesApi: APIs
    ): HomeRepository {
        return HomeRepository(moviesApi = moviesApi)
    }
}