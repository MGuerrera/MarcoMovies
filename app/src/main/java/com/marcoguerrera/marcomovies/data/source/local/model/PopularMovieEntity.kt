package com.marcoguerrera.marcomovies.data.source.local.model

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PopularMovieEntity(
    @ColumnInfo val overview: String,
    @ColumnInfo val originalLanguage: String,
    @ColumnInfo val originalTitle: String,
    @ColumnInfo val video: Boolean,
    @ColumnInfo val title: String,
    //@ColumnInfo val genreIds: List<Int>,//Room does not support the ability to store Lists directly, nor the ability to convert to/from Lists. It supports converting and storing POJO's.
    @ColumnInfo val genreIds: List<Int>,
    @ColumnInfo val posterPath: String,
    @ColumnInfo val backdropPath: String,
    @ColumnInfo val releaseDate: String,
    @ColumnInfo val popularity: Double,
    @ColumnInfo val voteAverage: Double,
    @PrimaryKey val id: Int,
    @ColumnInfo val adult: Boolean,
    @ColumnInfo val voteCount: Int
)