package com.kl3jvi.musicapp.data.persistence

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.kl3jvi.musicapp.domain.model.Artist
import com.squareup.moshi.Moshi
import javax.inject.Inject


@ProvidedTypeConverter
class ArtistConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromBadgeConverter(data: Artist): String {
        return moshi.adapter(Artist::class.java).toJson(data)
    }

    @TypeConverter
    fun toBadgeConverter(json: String): Artist? {
        return moshi.adapter(Artist::class.java).fromJson(json)
    }
}