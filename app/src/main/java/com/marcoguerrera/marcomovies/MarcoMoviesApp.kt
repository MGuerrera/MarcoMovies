package com.marcoguerrera.marcomovies

import android.app.Application
import androidx.room.Room
import com.marcoguerrera.marcomovies.data.source.local.db.AppDatabase

class MarcoMoviesApp: Application() {
    companion object {
        var db: AppDatabase? = null
        fun getDatabase(): AppDatabase? {
            return db
        }
    }
    override fun onCreate() {
        super.onCreate()
        db = Room.databaseBuilder(
            applicationContext,
            AppDatabase::class.java, "Movies"
        ).build()
    }
}