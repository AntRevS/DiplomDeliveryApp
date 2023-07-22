package com.antrevs.splash.di

import com.antrevs.splash.data.SessionRepositoryImpl
import com.antrevs.splash.domain.SessionRepository
import dagger.Binds
import dagger.Module

@Module
interface SplashModule {

    @Binds
    fun SessionRepositoryImpl.bindRepository(): SessionRepository
}
