package com.kl3jvi.musicapp.di

import com.kl3jvi.musicapp.data.repository.FavoritesRepositoryImpl
import com.kl3jvi.musicapp.data.repository.SearchRepositoryImpl
import com.kl3jvi.musicapp.domain.repository.FavoritesRepository
import com.kl3jvi.musicapp.domain.repository.SearchRepository
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
    abstract fun bindFavoritesRepository(repository: FavoritesRepositoryImpl): FavoritesRepository

    @ActivityRetainedScoped
    @Binds
    abstract fun bindSearchRepository(repository: SearchRepositoryImpl): SearchRepository


}
