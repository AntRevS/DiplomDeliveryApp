package com.antrevs.core.presentation

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalLifecycleOwner
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.flowWithLifecycle
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector
import kotlinx.coroutines.flow.collectLatest

@Composable
fun <T> Flow<T>.CollectionWithLifecycle(
    lifecycleOwner: LifecycleOwner = LocalLifecycleOwner.current,
    minActiveState: Lifecycle.State = Lifecycle.State.RESUMED,
    collector: FlowCollector<T>,
) {
    val flowLifecycleAware = remember(this, lifecycleOwner) {
        this.flowWithLifecycle(lifecycleOwner.lifecycle, minActiveState)
    }
    LaunchedEffect(flowLifecycleAware) {
        flowLifecycleAware.collectLatest(collector::emit)
    }
}
