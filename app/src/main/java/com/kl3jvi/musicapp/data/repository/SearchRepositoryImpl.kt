package com.kl3jvi.musicapp.data.repository

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import com.kl3jvi.musicapp.data.remote.LastFMClient
import com.kl3jvi.musicapp.data.remote.MusicPagingSource
import com.kl3jvi.musicapp.domain.model.Album
import com.kl3jvi.musicapp.domain.repository.SearchRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchRepositoryImpl @Inject constructor(
    private val api: LastFMClient
) : SearchRepository {
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