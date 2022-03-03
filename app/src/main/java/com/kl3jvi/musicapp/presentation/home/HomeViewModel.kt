package com.kl3jvi.musicapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kl3jvi.musicapp.domain.model.Album
import com.kl3jvi.musicapp.domain.use_case.GetFavoriteAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getFavoriteAlbumsUseCase: GetFavoriteAlbumsUseCase
) : ViewModel() {
    private val _favoritesList: MutableStateFlow<List<Album>> = MutableStateFlow(emptyList())
    var favoritesList: StateFlow<List<Album>> = _favoritesList

    init {
        getFavorites()
    }

    private fun getFavorites() {
        getFavoriteAlbumsUseCase().onEach {
            _favoritesList.value = it
        }.launchIn(viewModelScope)
    }

}