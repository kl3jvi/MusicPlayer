package com.kl3jvi.musicapp.domain.use_case

import com.kl3jvi.musicapp.domain.model.Album
import com.kl3jvi.musicapp.domain.repository.FavoritesRepository
import javax.inject.Inject

class DeleteAlbumFromDatabaseUseCase @Inject constructor(
    private val repository: FavoritesRepository

) {
    suspend operator fun invoke(album: Album) = repository.deleteAlbumFromDatabase(album = album)
}