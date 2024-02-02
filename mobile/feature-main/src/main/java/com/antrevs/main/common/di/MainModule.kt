package com.antrevs.main.common.di

import com.antrevs.main.common.data.ProductsRepositoryImpl
import com.antrevs.main.common.domain.ProductsRepository
import dagger.Binds
import dagger.Module

@Module
interface MainModule {

    @Binds
    fun ProductsRepositoryImpl.binsRepository(): ProductsRepository
}
