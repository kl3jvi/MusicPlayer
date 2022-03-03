package com.kl3jvi.musicapp.data.remote

import javax.inject.Inject

class LastFMClient @Inject constructor(
    private val lastFMService: LastFMService
) {
    suspend fun getTopAlbums(artistName: String, page: Int) =
        lastFMService.getTopAlbumByArtist(
            method = METHOD,
            apiKey = API_KEY,
            artistName = artistName,
            page = page,
            format = FORMAT
        )


    companion object {
        private const val API_KEY = "e8e789f50ee61518a7aaa9d549ff9239"
        private const val METHOD = "artist.gettopalbums"
        private const val FORMAT = "json"
    }
}