package com.kl3jvi.musicapp.data.remote

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.kl3jvi.musicapp.data.remote.dto.toAlbum
import com.kl3jvi.musicapp.domain.model.Album
import com.kl3jvi.musicapp.domain.use_case.IsAlbumOnDBUseCase
import kotlinx.coroutines.coroutineScope

class MusicPagingSource(
    private val apiService: ListFMClient,
    private val artistName: String,
) : PagingSource<Int, Album>() {
    override fun getRefreshKey(state: PagingState<Int, Album>): Int? {
        return state.anchorPosition?.let { anchorPosition ->
            state.closestPageToPosition(anchorPosition)?.prevKey
        }
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Album> {
        val page = params.key ?: STARTING_PAGE_INDEX
        return try {
            val response = apiService.getTopAlbums(artistName, page)
                .topAlbums.albumDto.map { it.toAlbum() }


            LoadResult.Page(
                data = response,
                prevKey = if (page == STARTING_PAGE_INDEX) null else page - 1,
                nextKey = if (response.isNullOrEmpty()) null else page + 1
            )
        } catch (exception: Exception) {
            exception.printStackTrace()
            LoadResult.Error(exception)
        }
    }

    companion object {
        private const val STARTING_PAGE_INDEX = 1
    }
}