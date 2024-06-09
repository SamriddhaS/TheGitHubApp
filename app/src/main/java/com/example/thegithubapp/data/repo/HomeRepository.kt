package com.example.thegithubapp.data.repo

import android.util.Log
import com.example.thegithubapp.data.network.APIs
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class HomeRepository
@Inject
constructor(
    private val moviesApi: APIs
)
{
    /*suspend fun getPopularMoviesList():Resource<List<PopularMovie>>{
        val result = try {
            moviesApi.getPopularMoviesList().results
        }catch (e:Exception){
            return Resource.Error(null,e.message.toString())
        }
        return Resource.Success(result)
    }*/

}