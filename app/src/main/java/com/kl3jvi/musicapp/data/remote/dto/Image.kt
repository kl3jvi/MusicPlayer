package com.kl3jvi.musicapp.data.remote.dto


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Image(
    @Json(name = "size")
    val size: String,
    @Json(name = "#text")
    val text: String
)