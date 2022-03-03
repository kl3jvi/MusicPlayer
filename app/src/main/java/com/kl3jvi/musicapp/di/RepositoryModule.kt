package com.kl3jvi.musicapp.di

import com.kl3jvi.musicapp.data.repository.MusicRepositoryImpl
import com.kl3jvi.musicapp.domain.repository.MusicRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import kotlinx.coroutines.ExperimentalCoroutinesApi


@ExperimentalCoroutinesApi
@InstallIn(ActivityRetainedComponent::class)
@Module
abstract class RepositoryModule {

    @ActivityRetainedScoped
    @Binds
    abstract fun bindMusicRepository(repository: MusicRepositoryImpl): MusicRepository
}
