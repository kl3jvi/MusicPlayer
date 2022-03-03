package com.kl3jvi.musicapp.domain.use_case

import com.kl3jvi.musicapp.domain.model.Album
import com.kl3jvi.musicapp.domain.repository.FavoritesRepository
import javax.inject.Inject

class MarkAlbumAsFavoriteUseCase @Inject constructor(
    private val repository: FavoritesRepository
) {
    suspend operator fun invoke(album: Album) =
        repository.markAlbumAsFavorite(album = album.copy(isFavorite = true))
}