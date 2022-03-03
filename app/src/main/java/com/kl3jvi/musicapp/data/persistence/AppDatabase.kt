package com.kl3jvi.musicapp.data.persistence

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.kl3jvi.musicapp.domain.model.Album

@Database(entities = [Album::class], version = 1, exportSchema = true)
@TypeConverters(value = [ArtistConverter::class, ImageConverter::class])
abstract class AppDatabase : RoomDatabase() {
    abstract fun albumDao(): AlbumDao
}