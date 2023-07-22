package com.antrevs.core.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.antrevs.core.data.entity.ApiErrorResponseException
import com.antrevs.core.data.entity.UnauthorizedException
import com.antrevs.core.presentation.event.AlertEvent
import com.antrevs.core.presentation.navigation.NavEvent
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch

abstract class BaseViewModel : ViewModel() {

    private val _alertEvent = Channel<AlertEvent>()
    val alertEvent = _alertEvent.receiveAsFlow()

    private val _navigationEvent = Channel<NavEvent>()
    val navigationEvent = _navigationEvent.receiveAsFlow()

    protected fun launch(
        onApiError: ((errorCode: String) -> Boolean)? = null,
        action: suspend () -> Unit,
    ) = viewModelScope.launch {
        try {
            action()
        } catch (e: ApiErrorResponseException) {
            val isCustomHandler = onApiError?.invoke(e.code) ?: false
            if (!isCustomHandler) {
                defaultApiErrorResponseHandler(e)
            }
        } catch (e: UnauthorizedException) {
            navigate(NavEvent.Welcome)
        }
    }

    protected fun navigate(event: NavEvent) {
        viewModelScope.launch {
            _navigationEvent.send(event)
        }
    }

    protected fun showAlert(alertEvent: AlertEvent) {
        viewModelScope.launch {
            _alertEvent.send(alertEvent)
        }
    }

    private suspend fun defaultApiErrorResponseHandler(
        error: ApiErrorResponseException,
    ) {
        _alertEvent.send(
            AlertEvent(
                text = error.code,
                action = { navigate(NavEvent.Back) },
            )
        )
    }
}
