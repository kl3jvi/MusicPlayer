package com.kl3jvi.musicapp.domain.repository

import com.kl3jvi.musicapp.domain.model.Album
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    suspend fun markAlbumAsFavorite(album: Album)
    suspend fun deleteAlbumFromDatabase(album: Album)
    fun isAlbumOnDatabase(id: Int): Flow<Boolean>
    fun getFavoriteAlbumsFromDatabase(): Flow<List<Album>>
}
