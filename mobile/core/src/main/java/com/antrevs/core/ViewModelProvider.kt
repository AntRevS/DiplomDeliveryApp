package com.antrevs.core

import androidx.compose.runtime.Composable
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
inline fun <reified T: ViewModel>getViewModel(
    crossinline viewModelCreator: () -> T,
): T = viewModel(
    modelClass = T::class.java,
    key = null,
    viewModelStoreOwner = checkNotNull(LocalViewModelStoreOwner.current),
    factory = object : ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return (viewModelCreator() as T)
        }
    }
)
