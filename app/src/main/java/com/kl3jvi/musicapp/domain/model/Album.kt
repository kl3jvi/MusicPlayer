package com.kl3jvi.musicapp.domain.model

import android.os.Parcelable
import com.kl3jvi.musicapp.data.remote.dto.ImageDto
import kotlinx.parcelize.Parcelize

@Parcelize
data class Album(
    val artistDto: Artist,
    val imageDto: List<Image>,
    val name: String,
    val playCount: Int,
    val url: String
) : DomainModel, Parcelable {
    fun getImageUrl(): String {
        return imageDto.last().text
    }
}