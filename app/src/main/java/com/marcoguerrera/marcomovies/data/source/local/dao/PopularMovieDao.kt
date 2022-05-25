package com.marcoguerrera.marcomovies.data.source.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.marcoguerrera.marcomovies.data.source.local.model.PopularMovieEntity

@Dao
interface PopularMovieDao {
    @Query("SELECT * FROM popularmovieentity")
    fun getAll(): List<PopularMovieEntity>

    @Insert
    fun insertAll(vararg popularMoviesEntities: PopularMovieEntity)
}