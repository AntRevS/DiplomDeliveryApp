package com.antrevs.delivery.di.ui

import com.antrevs.core.presentation.DialogHolder
import com.antrevs.ui.presentation.DialogHolderImpl
import dagger.Binds
import dagger.Module

@Module
interface UiModule {

    @Binds
    fun DialogHolderImpl.bindDialogHolder(): DialogHolder
}
