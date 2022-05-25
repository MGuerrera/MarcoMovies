package com.marcoguerrera.marcomovies.model

data class PopularResponse(
    val page: Int,
    val totalPages: Int,
    val results: List<PopularMovie>,
    val totalResults: Int
)