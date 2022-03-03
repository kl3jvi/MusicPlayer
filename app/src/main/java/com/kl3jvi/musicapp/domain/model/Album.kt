package com.kl3jvi.musicapp.domain.model

import android.os.Parcelable
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize

@Entity
@Parcelize
data class Album(
    @PrimaryKey(autoGenerate = true)
    val id: Int = 0,
    val artist: Artist,
    val imageDto: List<Image>,
    val name: String,
    val playCount: Int,
    val url: String
) : DomainModel, Parcelable {
    fun getImageUrl(): String {
        return imageDto.last().text
    }
}