package com.kl3jvi.musicapp.data.remote.dto


import com.kl3jvi.musicapp.domain.model.Artist
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ArtistDto(
    @Json(name = "mbid")
    val mbid: String,
    @Json(name = "name")
    val name: String,
    @Json(name = "url")
    val url: String
)

fun ArtistDto.toArtist(): Artist {
    return Artist(
        mbid = mbid,
        name = name,
        url = url
    )
}

