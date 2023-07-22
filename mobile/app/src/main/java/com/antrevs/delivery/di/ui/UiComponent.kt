package com.antrevs.delivery.di.ui

import com.antrevs.core.di.ui.UiComponentApi
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
    modules = [
        UiModule::class,
    ],
)
interface UiComponent : UiComponentApi
