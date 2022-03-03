package com.kl3jvi.musicapp.domain.use_case

import com.kl3jvi.musicapp.domain.repository.FavoritesRepository
import javax.inject.Inject

class IsAlbumOnDBUseCase @Inject constructor(
    private val repo: FavoritesRepository
) {
    operator fun invoke(id: Int) = repo.isAlbumOnDatabase(id)
}