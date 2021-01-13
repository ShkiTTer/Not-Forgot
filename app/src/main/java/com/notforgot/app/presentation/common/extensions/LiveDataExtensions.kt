package com.notforgot.app.presentation.common.extensions

import androidx.lifecycle.MutableLiveData
import com.notforgot.app.presentation.common.ViewEvent

fun <T> MutableLiveData<ViewEvent<T>>.postEvent(value: T) {
    postValue(ViewEvent(value))
}