package com.kl3jvi.musicapp.data.repository

import com.kl3jvi.musicapp.data.persistence.AlbumDao
import com.kl3jvi.musicapp.domain.repository.FavoritesRepository
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(
    private val dao: AlbumDao
) : FavoritesRepository {
    override fun getFavoriteAlbumsFromDatabase() = dao.getAlbumList()
}