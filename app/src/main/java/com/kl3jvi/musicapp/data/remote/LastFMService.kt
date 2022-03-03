package com.kl3jvi.musicapp.data.remote

import com.kl3jvi.musicapp.data.remote.dto.TopAlbumsDto
import retrofit2.http.GET
import retrofit2.http.Query

interface LastFMService {
    //https://ws.audioscrobbler.com/2.0/?method=artist.gettopalbums&artist=lana&api_key=e8e789f50ee61518a7aaa9d549ff9239&format=json

    @GET("2.0/")
    suspend fun getTopAlbumByArtist(
        @Query("method") method: String,
        @Query("artist") artistName: String,
        @Query("api_key") apiKey: String,
        @Query("page") page: Int,
        @Query("format") format: String
    ): TopAlbumsDto
}