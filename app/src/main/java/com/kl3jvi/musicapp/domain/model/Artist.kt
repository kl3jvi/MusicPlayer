package com.kl3jvi.musicapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Artist(
    val mbid: String,
    val name: String,
    val url: String
) : DomainModel, Parcelable