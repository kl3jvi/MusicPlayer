package com.kl3jvi.musicapp.domain.repository

import com.kl3jvi.musicapp.domain.model.Album
import kotlinx.coroutines.flow.Flow

interface FavoritesRepository {
    fun getFavoriteAlbumsFromDatabase(): Flow<List<Album>>
}