package com.kl3jvi.musicapp.domain.model

import com.kl3jvi.musicapp.data.remote.dto.ArtistDto
import com.kl3jvi.musicapp.data.remote.dto.Image

data class Album(
    val artistDto: ArtistDto,
    val image: List<Image>,
    val name: String,
    val playcount: Int,
    val url: String
) {
    fun getImageUrl(): String {
        return image.last().text
    }
}
