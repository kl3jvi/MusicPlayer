package com.kl3jvi.musicapp.data.repository

import com.kl3jvi.musicapp.data.persistence.AlbumDao
import com.kl3jvi.musicapp.domain.model.Album
import com.kl3jvi.musicapp.domain.repository.FavoritesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FavoritesRepositoryImpl @Inject constructor(
    private val dao: AlbumDao
) : FavoritesRepository {
    override suspend fun markAlbumAsFavorite(album: Album) = dao.insertAlbum(album = album)
    override suspend fun deleteAlbumFromDatabase(album: Album) = dao.deleteAlbum(album)
    override fun isAlbumOnDatabase(id: Int): Flow<Boolean> = dao.isAlbumOnDatabase(id)
    override fun getFavoriteAlbumsFromDatabase() = dao.getAlbumList()
}