package com.kl3jvi.musicapp.presentation.home

import androidx.lifecycle.ViewModel
import com.kl3jvi.musicapp.domain.use_case.GetTopAlbumsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getTopAlbumsUseCase: GetTopAlbumsUseCase
) : ViewModel() {


}