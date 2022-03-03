package com.kl3jvi.musicapp.di

import android.app.Application
import androidx.room.Room
import com.kl3jvi.musicapp.data.persistence.AlbumDao
import com.kl3jvi.musicapp.data.persistence.AppDatabase
import com.kl3jvi.musicapp.data.persistence.ArtistConverter
import com.kl3jvi.musicapp.data.persistence.ImageConverter
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object PersistenceModule {
    @Provides
    @Singleton
    fun provideMoshi(): Moshi {
        return Moshi.Builder()
            .addLast(KotlinJsonAdapterFactory())
            .build()
    }

    @Provides
    @Singleton
    fun provideAppDatabase(
        application: Application,
        artistConverter: ArtistConverter,
        imageConverter: ImageConverter
    ): AppDatabase {
        return Room
            .databaseBuilder(application, AppDatabase::class.java, "albums.db")
            .fallbackToDestructiveMigration()
            .addTypeConverter(artistConverter)
            .addTypeConverter(imageConverter)
            .build()
    }

    @Provides
    @Singleton
    fun provideAlbumDao(appDatabase: AppDatabase): AlbumDao {
        return appDatabase.albumDao()
    }

    @Provides
    @Singleton
    fun provideArtistResponseConverter(moshi: Moshi): ArtistConverter {
        return ArtistConverter(moshi)
    }

    @Provides
    @Singleton
    fun provideImageResponseConverter(moshi: Moshi): ImageConverter {
        return ImageConverter(moshi)
    }
}