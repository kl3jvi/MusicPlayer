package com.kl3jvi.musicapp.domain.repository

import androidx.paging.PagingData
import com.kl3jvi.musicapp.domain.model.Album
import kotlinx.coroutines.flow.Flow

interface SearchRepository {
    fun getTopAlbums(artistName: String): Flow<PagingData<Album>>
}