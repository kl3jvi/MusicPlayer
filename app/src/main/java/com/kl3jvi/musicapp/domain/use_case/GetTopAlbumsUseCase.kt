package com.kl3jvi.musicapp.domain.use_case

import com.kl3jvi.musicapp.data.repository.MusicRepositoryImpl
import javax.inject.Inject

class GetTopAlbumsUseCase @Inject constructor(
    private val repository: MusicRepositoryImpl
) {
    operator fun invoke(artistName: String) = repository.getTopAlbums(artistName)
}