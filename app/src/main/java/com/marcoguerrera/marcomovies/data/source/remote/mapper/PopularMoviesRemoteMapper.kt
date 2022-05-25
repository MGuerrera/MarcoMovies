package com.marcoguerrera.marcomovies.data.source.remote.mapper

import com.marcoguerrera.marcomovies.data.source.remote.model.PopularResultsItem
import com.marcoguerrera.marcomovies.model.PopularMovie

object PopularMoviesRemoteMapper {
    fun mapFromRemote(popMov: PopularResultsItem): PopularMovie {
        return PopularMovie(
            popMov.overview ?: "",
            popMov.originalLanguage ?: "",
            popMov.originalTitle ?: "",
            popMov.video ?: false,
            popMov.title ?: "",
            (popMov.genreIds ?: emptyList<Int>()) as List<Int>,
            popMov.posterPath ?: "",
            popMov.backdropPath ?: "",
            popMov.releaseDate ?: "",
            popMov.popularity ?: -1.0,
            popMov.voteAverage ?: -1.0,
            popMov.id ?: -1,
            popMov.adult ?: false,
            popMov.voteCount ?: -1
        )
    }
}