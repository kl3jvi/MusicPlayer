package com.kl3jvi.musicapp.presentation.details

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.kl3jvi.musicapp.domain.model.Album
import com.kl3jvi.musicapp.domain.use_case.DeleteAlbumFromDatabaseUseCase
import com.kl3jvi.musicapp.domain.use_case.IsAlbumOnDBUseCase
import com.kl3jvi.musicapp.domain.use_case.MarkAlbumAsFavoriteUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.plus
import javax.inject.Inject

@HiltViewModel
class DetailsViewModel @Inject constructor(
    private val markAlbumAsFavoriteUseCase: MarkAlbumAsFavoriteUseCase,
    private val deleteAlbumFromDatabaseUseCase: DeleteAlbumFromDatabaseUseCase,
    private val isAlbumOnDBUseCase: IsAlbumOnDBUseCase
) : ViewModel() {


    fun markAsFavorite(album: Album) =
        viewModelScope.launch(Dispatchers.IO) { // IO Dispatcher for inserting on database
            markAlbumAsFavoriteUseCase(album = album)
        }


    fun deleteFromFavorite(album: Album) =
        viewModelScope.launch(Dispatchers.IO) { // IO Dispatcher for deleting from database
            deleteAlbumFromDatabaseUseCase(album = album)
        }

    private val _isOnDb: MutableStateFlow<Boolean> = MutableStateFlow(false)
//    var exists: StateFlow<Boolean> = _isOnDb
//
//    fun isItemOnDatabase(id: Int) {
//        isAlbumOnDBUseCase(id).onEach {
//            _isOnDb.value = it // IO Dispatcher for deleting from database
//        }.launchIn(viewModelScope + Dispatchers.IO)
//    }
}


