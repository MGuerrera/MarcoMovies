package com.marcoguerrera.marcomovies.data.repository

import com.marcoguerrera.marcomovies.data.source.remote.model.PopularResultsItem
import com.marcoguerrera.marcomovies.data.source.remote.service.MoviesService
import com.marcoguerrera.marcomovies.data.source.remote.api.RetrofitClient
import com.marcoguerrera.marcomovies.util.API_KEY

class MovieRepository {

    private val TAG = "MovieRepository"

    suspend fun getPopular(): List<PopularResultsItem>? {
        val client = RetrofitClient.getInstance().create(MoviesService::class.java).getPopular(
            API_KEY, 1)
        return  client.body()?.results
    }
}