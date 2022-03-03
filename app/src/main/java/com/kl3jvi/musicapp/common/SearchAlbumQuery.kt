package com.kl3jvi.musicapp.common

import androidx.appcompat.widget.SearchView

interface SearchAlbumQuery : SearchView.OnQueryTextListener {
    override fun onQueryTextSubmit(newText: String?): Boolean {
        return false
    }
}