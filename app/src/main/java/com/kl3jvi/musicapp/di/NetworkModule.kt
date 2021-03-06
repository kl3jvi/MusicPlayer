package com.kl3jvi.musicapp.di

import com.kl3jvi.musicapp.common.Constants.BASE_URL
import com.kl3jvi.musicapp.data.remote.HttpRequestInterceptor
import com.kl3jvi.musicapp.data.remote.LastFMClient
import com.kl3jvi.musicapp.data.remote.LastFMService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    @Provides
    @Singleton
    fun provideOkHttpClient(): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(HttpRequestInterceptor())
            .build()
    }

    @Provides
    @Singleton
    fun provideRetrofit(okHttpClient: OkHttpClient): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(BASE_URL)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun provideListFMService(retrofit: Retrofit): LastFMService {
        return retrofit.create(LastFMService::class.java)
    }

    @Provides
    @Singleton
    fun provideListFMClient(lastFMService: LastFMService): LastFMClient {
        return LastFMClient(lastFMService)
    }
}
