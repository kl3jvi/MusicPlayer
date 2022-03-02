package com.kl3jvi.musicapp.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TopAlbumsDto(
    @Json(name = "topalbums")
    val topAlbums: TopAlbums
)

@JsonClass(generateAdapter = true)
data class TopAlbums(
    @Json(name = "album")
    val albumDto: List<AlbumDto>,
    @Json(name = "@attr")
    val attr: Attr
)