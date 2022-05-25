package com.marcoguerrera.marcomovies.data.source.remote.service

import com.marcoguerrera.marcomovies.data.source.remote.model.PopularResponse
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface MoviesService {

    @GET("movie/popular?")
    suspend fun getPopular(@Query("api_key") key:String,@Query("page") page:Int): Response<PopularResponse>

}