package com.kl3jvi.musicapp.data.remote.dto


import com.kl3jvi.musicapp.domain.model.Album
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class AlbumDto(
    @Json(name = "artist")
    val artistDto: ArtistDto,
    @Json(name = "image")
    val image: List<Image>,
    @Json(name = "name")
    val name: String,
    @Json(name = "playcount")
    val playCount: Int,
    @Json(name = "url")
    val url: String
)

fun AlbumDto.toAlbum(): Album {
    return Album(
        artistDto = artistDto,
        image = image,
        name = name,
        playcount = playCount,
        url = url
    )
}