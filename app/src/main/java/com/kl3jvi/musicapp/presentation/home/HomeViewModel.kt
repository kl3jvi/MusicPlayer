package com.kl3jvi.musicapp.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import com.kl3jvi.musicapp.domain.use_case.GetFavoriteAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getFavoriteAlbumsUseCase: GetFavoriteAlbumsUseCase
) : ViewModel() {

    val favoritesList = getFavoriteAlbumsUseCase().asLiveData()

}