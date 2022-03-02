package com.kl3jvi.musicapp.presentation.search

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.kl3jvi.musicapp.domain.model.Album
import com.kl3jvi.musicapp.domain.use_case.GetTopAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(
    private val getTopAlbumsUseCase: GetTopAlbumsUseCase
) : ViewModel() {
    private var currentQueryValue: String? = null
    private var currentSearchResult: Flow<PagingData<Album>>? = null

    fun searchPictures(queryString: String): Flow<PagingData<Album>> {
        currentQueryValue = queryString
        val newResult: Flow<PagingData<Album>> =
            getTopAlbumsUseCase(queryString).cachedIn(viewModelScope)
        currentSearchResult = newResult
        return newResult
    }
}