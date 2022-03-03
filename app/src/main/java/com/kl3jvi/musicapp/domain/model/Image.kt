package com.kl3jvi.musicapp.domain.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Image(
    val size: String,
    val text: String
) : Parcelable
