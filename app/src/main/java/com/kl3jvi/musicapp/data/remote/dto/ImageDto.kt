package com.kl3jvi.musicapp.data.remote.dto


import com.kl3jvi.musicapp.domain.model.Image
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ImageDto(
    @Json(name = "size")
    val size: String,
    @Json(name = "#text")
    val text: String
)

fun ImageDto.toImage(): Image {
    return Image(
        size = size,
        text = text
    )
}