package com.kl3jvi.musicapp.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Attr(
    @Json(name = "artist")
    val artist: String,
    @Json(name = "page")
    val page: String,
    @Json(name = "perPage")
    val perPage: String,
    @Json(name = "total")
    val total: String,
    @Json(name = "totalPages")
    val totalPages: String
)