package com.kl3jvi.musicapp.domain.use_case

import com.kl3jvi.musicapp.domain.model.Album
import com.kl3jvi.musicapp.domain.repository.FavoritesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFavoriteAlbumsUseCase @Inject constructor(
    private val repository: FavoritesRepository
) {
    operator fun invoke(): Flow<List<Album>> = repository.getFavoriteAlbumsFromDatabase()
}