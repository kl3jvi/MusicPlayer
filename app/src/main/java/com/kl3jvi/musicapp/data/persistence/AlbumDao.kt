package com.kl3jvi.musicapp.data.persistence

import androidx.room.*
import com.kl3jvi.musicapp.domain.model.Album
import kotlinx.coroutines.flow.Flow

@Dao
interface AlbumDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAlbum(album: Album)

    @Query("SELECT * FROM Album ORDER BY ID")
    fun getAlbumList(): Flow<List<Album>>

    @Delete
    suspend fun deleteAlbum(album: Album)
}