package com.marcoguerrera.marcomovies.data.source.local.converter

import androidx.room.TypeConverter

class Converters {
    @TypeConverter
    fun idsToString(ids: List<Int?>?): String? {
        return ids?.joinToString("-")
    }

    @TypeConverter
    fun stringToIds(ids: String): List<Int> {
        return ids.split("-").map{ it.trim() }.map { it.toInt() }
    }
}