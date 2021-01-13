package com.notforgot.app.presentation.common

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * <S> for state type
 * <E> for event type
 */
abstract class StateViewModel<S, E> : ViewModel() {
    protected val _state = MutableLiveData<S>()
    val state: LiveData<S> get() = _state

    protected val _event = MutableLiveData<ViewEvent<E>>()
    val event: LiveData<ViewEvent<E>> get() = _event
}