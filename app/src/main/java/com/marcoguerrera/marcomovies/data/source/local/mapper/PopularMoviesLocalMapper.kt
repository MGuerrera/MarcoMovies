package com.marcoguerrera.marcomovies.data.source.local.mapper

import com.marcoguerrera.marcomovies.data.source.local.model.PopularMovieEntity
import com.marcoguerrera.marcomovies.model.PopularMovie

object PopularMoviesLocalMapper {
    fun mapToLocal(popMov: PopularMovie): PopularMovieEntity {
        return PopularMovieEntity(
            popMov.overview,
            popMov.originalLanguage,
            popMov.originalTitle,
            popMov.video,
            popMov.title,
            popMov.genreIds,
            popMov.posterPath,
            popMov.backdropPath,
            popMov.releaseDate,
            popMov.popularity,
            popMov.voteAverage,
            popMov.id,
            popMov.adult,
            popMov.voteCount
        )
    }

    fun mapFromLocal(popMovEnt: PopularMovieEntity): PopularMovie {
        return PopularMovie(
            popMovEnt.overview,
            popMovEnt.originalLanguage,
            popMovEnt.originalTitle,
            popMovEnt.video,
            popMovEnt.title,
            popMovEnt.genreIds,
            popMovEnt.posterPath,
            popMovEnt.backdropPath,
            popMovEnt.releaseDate,
            popMovEnt.popularity,
            popMovEnt.voteAverage,
            popMovEnt.id,
            popMovEnt.adult,
            popMovEnt.voteCount
        )
    }
}