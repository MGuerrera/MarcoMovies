package com.marcoguerrera.marcomovies.data.source.local.db

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.marcoguerrera.marcomovies.data.source.local.converter.Converters
import com.marcoguerrera.marcomovies.data.source.local.dao.PopularMovieDao
import com.marcoguerrera.marcomovies.data.source.local.model.PopularMovieEntity

@Database(entities = [PopularMovieEntity::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun popularMoviesDao(): PopularMovieDao

/*    companion object {
        private var INSTANCE: AppDatabase? = null

        fun getInstance(context: Context): AppDatabase? {
            if (INSTANCE == null) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context.applicationContext, AppDatabase::class.java, "movies.db").build()
                }
            }
            return INSTANCE
        }

        fun destroyInstance() {
            INSTANCE = null
        }
    }*/
}