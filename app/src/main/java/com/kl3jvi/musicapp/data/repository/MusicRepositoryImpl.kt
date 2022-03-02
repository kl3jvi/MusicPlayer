package com.kl3jvi.musicapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kl3jvi.musicapp.data.remote.ListFMClient
import com.kl3jvi.musicapp.data.remote.MusicPagingSource
import com.kl3jvi.musicapp.domain.model.Album
import com.kl3jvi.musicapp.domain.repository.MusicRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class MusicRepositoryImpl @Inject constructor(
    private val api: ListFMClient
) : MusicRepository {
    override fun getTopAlbums(artistName: String): Flow<PagingData<Album>> {
        return Pager(
            config = PagingConfig(enablePlaceholders = false, pageSize = NETWORK_PAGE_SIZE),
            pagingSourceFactory = { MusicPagingSource(api, artistName) }
        ).flow
    }

    companion object {
        private const val NETWORK_PAGE_SIZE = 50 // Amount of items per page :)
    }
}