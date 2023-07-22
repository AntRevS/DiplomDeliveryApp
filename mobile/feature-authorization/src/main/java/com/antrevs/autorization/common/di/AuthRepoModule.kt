package com.antrevs.autorization.common.di

import com.antrevs.autorization.common.data.AuthRepositoryImpl
import com.antrevs.autorization.common.domain.AuthRepository
import dagger.Binds
import dagger.Module

@Module
interface AuthRepoModule {

    @Binds
    fun AuthRepositoryImpl.bindRepository(): AuthRepository
}