package com.kl3jvi.musicapp.domain.use_case

import com.kl3jvi.musicapp.domain.repository.MusicRepository
import javax.inject.Inject

class GetTopAlbumsUseCase @Inject constructor(
    private val repository: MusicRepository
) {
    operator fun invoke(artistName: String) = repository.getTopAlbums(artistName)
}